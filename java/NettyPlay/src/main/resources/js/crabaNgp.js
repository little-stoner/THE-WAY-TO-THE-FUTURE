initMs(function(ms, util) {
    if (!ms) {
        return;
    }
    //调试方式，默认不开启
    // ms.router = {
    //     debugMs: {
    //         aloneDeploy: 'shell',
    //         profileId: '111',
    //         employeeId: '2332',
    //         serverId: '10008',
    //         gateway: "http://localhost:9999"
    //     },
    //     'ngp-authorization': 'jwt',
    //     'ngp-router': 'ngprt'
    // };

    String.prototype.replaceAll = function(oldValue, newValue) {
        if (!this || !oldValue || !newValue) {
            return '';
        }
        return this.replace(new RegExp(oldValue, 'gm'), newValue);
    }

    var auxiliary = {
        forEach: function(obj, cb) { //cb返回true表示break;
            if (!obj) {
                return;
            }
            var typeName = typeof obj;
            if (typeName == 'function') {
                return obj;
            }
            if (typeName == "string") {
                for (var i = 0; i < obj.length; i++) {
                    if (cb(obj.substr(i, 1), i)) {
                        break;
                    }
                }
                return obj;
            }
            if (typeName == "object") {
                if (obj.length === undefined) {
                    //对象
                    var keys = Object.keys(obj);
                    for (var i = 0; i < keys.length; i++) {
                        if (cb(keys[i], i)) {
                            break;
                        }
                    }
                } else {
                    //数组
                    for (var i = 0; i < obj.length; i++) {
                        if (cb(obj[i], i)) {
                            break;
                        }
                    }
                }
                return obj;
            }
            return obj;
        }
    }

    auxiliary.forEach(auxiliary, function(key) {
        ms[key] = auxiliary[key];
    })

    ms.setBusinessControlFullNameFun = function(serverName, getBusinessControlFullFun) { //设置业务控件
        if (typeof getBusinessControlFullFun != 'function') {
            throw new Error('第二个参数getBusinessControlFullFun(传入业务控件名称)必须是一个返回字符串的函数');
        }
        if (!ms.businessFun) {
            ms.businessFun = {};
        }
        ms.businessFun[serverName] = getBusinessControlFullFun;
    }

    var configLoadingItems = {};
    //获取ngp配置
    ms.ngpConfig = {
        unlockConfig: function(configName) {
            delete configLoadingItems[configName];
        },
        saveConfig: function(configName, data) {
            var url = this["_" + configName];
            if (configName && configName.indexOf('.') >= 0) {
                throw new Error("暂不支持带.的配置保存")
            }
            if (!url) {
                throw new Error("未指定" + configName + "对应的保存地址")
            }
            var data = $common.ajaxSync({
                url: url,
                data: data,
                router: 'ngp'
            });
            if (data.code != 200) {
                var msg = data.message ? data.message : '保存配置出错，请重试';
                throw Error.abort(msg);
            }
            $ms.ngpConfig[configName] = data;
        },
        setConfig: function(configName, configUrl, urlData, defaultData, success, saveUrl) {
            if (!configUrl) {
                throw new Error('请配置' + configName + '的请求地址！');
            }
            if (configLoadingItems[configName]) {
                console.log('重复加载' + configName);
                return;
            }
            var configTemp = '_' + configName;
            this[configTemp] = saveUrl;
            var nameArray = configName.split('.');
            if (nameArray.length > 1 && nameArray[nameArray.length - 1] == '.') {
                throw new Error('【' + nameArray + '】 最后一位不能是.')
            }

            var object = ms.ngpConfig;
            for (var i = 0; i < nameArray.length - 1; i++) {
                var item = nameArray[i];
                if (!object[item]) {
                    object[item] = {};
                }
                object = object[item];
            }
            var objectItemName = nameArray.length > 0 && nameArray[nameArray.length - 1] ? nameArray[nameArray.length - 1] : configName;
            var url = configUrl;

            var data = $common.ajaxSync({
                url: url,
                data: urlData,
                router: 'ngp'
            });
            if (data.code != 200) {
                var msg = data.message ? data.message : '获取配置出错，请重试';
                throw Error.abort(msg);
            }
            configLoadingItems[configName] = data.data;
            if (!object[objectItemName]) {
                var tempObjectItemName = configName;
                Object.defineProperty(object, objectItemName, {
                    configurable: false,
                    enumerable: false,
                    get: function() {
                        if (configLoadingItems && configLoadingItems[tempObjectItemName]) {
                            return configLoadingItems[tempObjectItemName];
                        }
                        return defaultData ? defaultData : {};
                    }
                });
            }
            if (success) {
                success(object[objectItemName]);
            }
        }
    };
    ms.bus = (function() {
        var bus = {};
        return {
            add: function(name, cb) {
                if (typeof cb != 'function') {
                    throw new Error('总线通知第二个参数当前只支持传入函数')
                }
                var events = bus[name];
                if (!events) {
                    bus[name] = [];
                    events = bus[name];
                }
                events.push(cb);
            },
            notifyOnce: function(name, value) { //通知一次
                if (!bus[name]) {
                    return;
                }
                var events = bus[name];
                for (var i = 0; i < events.length; i++) {
                    var event = events[i];
                    event(value);
                }
                delete bus[name];
            }
        }
    })();
    ms.register = {
        businessControl: function(controlName, baseClass, property) { //注册一般控件
            if (!controlName) {
                throw new Error("请先设置业务控件的名");
            }
            controlName = controlName.trim();
            if (!baseClass) {
                baseClass = 'Sys.Control.BusinessControl';
            } else if (typeof baseClass != 'string') {
                property = baseClass;
                baseClass = 'Sys.Control.BusinessControl';
            }
            var funStr = '%s=function(){%s.initializeBase(this);};%s.prototype = {};%s.registerClass(\'%s\', ' + baseClass + '); return %s;';
            var control = (new Function(funStr.replaceAll('%s', controlName)))();
            if (property) {
                var keys = Object.keys(property);
                for (var i = 0; i < keys.length; i++) {
                    var key = keys[i];
                    if (typeof property[key] == 'function') {
                        control.prototype[key] = property[key];
                    }
                }
            }
        }
    }

    ms.power = {}; //权限

    var modelLoader = {}; //记录模块加载事件
    ms.create = function(modelName, needLoadedJs, property) {
        if (!modelName) {
            throw new Error('模块名不能为空');
        }
        if (modelLoader[modelName]) {
            throw new Error('重复定义模块名称' + modelName);
        }
        modelLoader[modelName] = {
            loadedTask: []
        };

        function loadJs(items) {
            if (!items || items.length <= 0) {
                window.setTimeout(function() {
                    //执行加载后事件
                    for (var i = 0; i < modelLoader[modelName].loadedTask.length; i++) {
                        var task = modelLoader[modelName].loadedTask[i];
                        if (!task.cb) {
                            continue;
                        }
                        task.cb.apply(task.cb, task.params)
                    }
                    delete modelLoader[modelName].loadedTask;
                })
                return;
            }
            var item = items.splice(0, 1)[0];
            if (item.trim().length == 0) {
                loadJs(items);
            } else {
                $common.loadScript(item, function() {
                    loadJs(items);
                }, null, true); //需要同步加载资源
            }
        }
        if (typeof needLoadedJs == 'string') {
            window.setTimeout(function() {
                var jsItems = needLoadedJs.split(',');
                loadJs(jsItems);
            })
        }
        return property;
    }

    //制定API拦截器方法
    ms.setResponseInterceptorFun = function(serverName, getResponseInterceptorFun) {
        if (typeof getResponseInterceptorFun != 'function') {
            throw new Error('第二个参数getResponseInterceptorFun(传入API拦截器)必须是一个的函数');
        }
        if (!ms.responseInterceptor) {
            ms.responseInterceptor = {};
        }
        ms.responseInterceptor[serverName] = getResponseInterceptorFun;
    }

    function getMsName(obj) {
        if (!obj) {
            return '';
        }
        if (typeof obj == 'string') {
            return obj.split('.')[0];
        }
        return obj.constructor.__typeName.split('.')[0];
    }
    var temp = ms;
    return {
        apiHeaders: function() {
            if (!temp.router) {
                return {};
            }
            var router = temp.router;
            var debugMs = router.debugMs;
            var result = {};
            if (debugMs) {
                result = {
                    'ngp-authorization': router['ngp-authorization'],
                    'ngp-router': JSON.stringify({
                        profileId: debugMs.profileId,
                        employeeId: debugMs.employeeId,
                        serverId: debugMs.serverId,
                        deloyId: debugMs.deloyId,
                        deploy: debugMs.deploy,
                        productId: debugMs.productId,
                        adminStatus: $ms.ngpConfig && $ms.ngpConfig.Sys && $ms.ngpConfig.Sys.userInfo ? $ms.ngpConfig.Sys.userInfo.isadmin : false,
                        routes: debugMs.routes
                    }),
                    isdebug: true
                }
            } else {
                result = {
                    'ngp-authorization': router['ngp-authorization'],
                    'ngp-router': router['ngp-router']
                }
            }
            if ($ms.server) {
                result["ngp-debug-router"] = JSON.stringify($ms.server);
            }
            return result;
        },
        serverName: function(obj, aloneApi) { //设置微服务前缀
            var router = temp.router;
            if (!router) {
                if (obj.indexOf('.') >= 0) {
                    obj = obj.substr(0, typeName.indexOf('.'));
                }
                return obj;
            }
            var debugMs = router.debugMs;
            var msName = getMsName(obj);
            if (!debugMs) {
                return window.location.origin + '/' + msName; // + '/';
            }
            //全部支持全路径，确保打印也能获取到全路径打印
            if (msName == debugMs.aloneDeploy) {
                if (aloneApi) {
                    return debugMs.aloneServer + '/' + msName; // + '/';
                } else {
                    return window.location.origin + '/' + msName; // + '/';
                }
            }

            if (debugMs.gateway) {
                return debugMs.gateway + '/' + msName; // + '/';
            } else {
                return window.location.origin + '/' + msName; // + '/';
            }
        },
        injectBusinessControl: function(controlBusinessName, controlAction, businessData) {
            var serverName = controlBusinessName.split('.');
            var index = controlBusinessName.indexOf('.');
            if (index >= 0) {
                serverName = controlBusinessName.substr(0, index);
                controlBusinessName = controlBusinessName.substr(index + 1);
            } else {
                serverName = getMsName(controlAction);
            }
            var getBusinessControlFullNameFun = temp.businessFun ? temp.businessFun[serverName] : '';
            if (!getBusinessControlFullNameFun || typeof getBusinessControlFullNameFun != 'function') {
                console.log('未设置服务' + serverName + '对应的【业务控件全名获取】方法/r/n请调用$ms.setBusinessControlFullNameFun(' + serverName + ', function(business){return ***.business});');
                return;
            }
            var businessControlFullName = getBusinessControlFullNameFun(controlBusinessName);
            if (!businessControlFullName) {
                return;
            }
            if (evil2(businessControlFullName)) {
                this[controlBusinessName] = evil2('new ' + businessControlFullName + '();');
                this[controlBusinessName].bindActionAndControl(controlAction, this, businessData);
            } else if (modelLoader[serverName] && modelLoader[serverName].loadedTask) {
                var item = {
                    params: [controlBusinessName, businessControlFullName, controlAction, this],
                    cb: function(controlBusinessName, businessControlFullName, controlAction, sender) {
                        sender[controlBusinessName] = evil2('new ' + businessControlFullName + '();');
                        sender[controlBusinessName].bindActionAndControl(controlAction, sender, businessData);
                    }
                }
                modelLoader[serverName].loadedTask.push(item); //记录加载后事件
            }
        },
        getAPIServiceUrl: function(serverName) {
            if (!serverName && temp && temp.router && temp.router.debugMs && temp.router.debugMs.aloneDeploy) {
                return temp.router.debugMs.aloneServer + '/';
            }
            if (serverName && temp && temp.router && temp.router.debugMs) {
                if (temp.router.debugMs.aloneServer && serverName == temp.router.debugMs.aloneDeploy) {
                    serverName = temp.router.debugMs.aloneServer + '/' + serverName + '/';
                } else if (temp.router.debugMs.gateway) {
                    serverName = temp.router.debugMs.gateway + '/' + serverName + '/';
                } else {
                    console.log('调试模式下，未设置gateway地址')
                }
            }
            return serverName;
        },
        responseInterceptor: function(serverName, url, value) {
            if (url && url.indexOf('pm/getMenu') >= 0 && value.code == '200') {
                //处理权限(不能修改)
                var permissions = value.data.permissions;
                var permissionDatas = {};
                for (var i = 0; i < permissions.length; i++) {
                    var item = permissions[i];
                    var serverName = item.serverName;
                    var serverItem = temp.power[serverName];
                    if (!serverItem) {
                        permissionDatas[serverName] = {};
                        Object.defineProperty(temp.power, serverName, {
                            configurable: false, //不能删除
                            enumerable: false, //不能枚举
                            writable: false, //不能修改
                            value: permissionDatas[serverName]
                        });
                        serverItem = permissionDatas[serverName];
                    }
                    if (!serverItem[item.serverKey]) {
                        Object.defineProperty(serverItem, item.serverKey, {
                            configurable: false, //不能删除
                            enumerable: false, //不能枚举
                            writable: false, //不能修改
                            value: {
                                name: item.name,
                                value: item.value,
                                msg: item.msg
                            }
                        });
                    }
                }
            }
            if (!temp.responseInterceptor) {
                return;
            }
            return temp.responseInterceptor[serverName];
        },
        getPower: function(value) {
            var index = value.indexOf('.');
            if (index <= 0) {
                throw new Error('权限获取格式必须是：模块名.关键字');
            }
            var serverName = value.substr(0, index);
            var key = value.substr(index + 1);
            if (!key) {
                throw new Error('权限key不能为空');
            }
            if (!temp.power[serverName] || !temp.power[serverName][value] || !temp.power[serverName][value].value) {
                return false;
            }
            return true;
        },
        interceptServerName: function(url) {
            if (url && url.indexOf('_Sys/UI/') >= 0 && url.indexOf('shell/_Sys/UI/') < 0) {
                if (url.startsWith('/')) {
                    url = 'shell' + url;
                } else {
                    url = 'shell/' + url;
                }
            }
            return url;
        }
    }
});

//绑定方法到主action，方便注入方法，处理菜单在不同模块中的OnClick事件
$ms.appendFunToMainAction = function(methodname, fun) {
    var forms = Sys.Application._forms;
    if (forms.length == 0) {
        throw new Error('未找到页面');
    }
    var action = forms[0].get_action();
    if (!action) {
        throw new Error('未找到页面对应的action');
    }
    if (!action[methodname]) {
        throw new Error(action + '已定义方法' + methodname);
    }
    action[methodname] = fun;
}

initMs = null; //清除
Sys.UI.PageAction.prototype.get_businessModel = function () {
    if (!this.$businessModel) {
        this.$businessModel = new Sys.Control.BusinessModel(this);
    }
    return this.$businessModel;
}
Type.registerNamespace('Sys.Control');
//业务模型
Sys.Control.BusinessModel = function (action) {
    this.action = action;
    if (!action.$businessControls) {
        action.$businessControls = [];
    }
}
Sys.Control.BusinessModel.prototype = {
    //总线模式
    bus: function (responseMethodName, newData, oldData, orders) {
        var notifyKey = responseMethodName;
        var busInfo = {};
        if (!this.action) {
            return busInfo;
        }
        var notifys = this.action.$businessControls;
        if (!notifys) {
            return busInfo;
        }
        //只支持数组
        orders = orders && orders.length && typeof orders != 'string' ? orders : [];
        var form = this.action.get_form();
        for (var j = 0; j < orders.length; j++) {
            var orderId = orders[j];
            if (!form[orderId]) {
                continue;
            }
            var control = form[orderId];
            if(!control.get_visible()){
                continue;
            }

            if (!control.get_business()) {
                console.log('未验证控件' + orderId);
                continue;
            }
            var item = control[this._getBusinessName(control.get_business())];
            if (!item[notifyKey]) {
                continue;
            }
            if (item[notifyKey](newData, oldData, busInfo) === false) {
                return busInfo;
            }
        }
        for (var i = 0; i < notifys.length; i++) {
            var item = notifys[i];
            if (!item[notifyKey]) {
                continue;
            }
            if(!item.control.get_visible()){
                continue;
            }
            if (item.control) {//已根据顺序执行
                var id = item.control.get_id();
                if (orders.indexOf(id) >= 0) {
                    continue;
                }
            }
            if (item[notifyKey](newData, oldData, busInfo) === false) {
                return busInfo;
            }
        }
        return busInfo;
    },
    _findControl: function (dataField, form, first) {
        if (!form) {
            return null;
        }
        var control = form[dataField];
        var index = dataField.indexOf('.');
        if (index < 0) {
            if (!control && first && form.get_isChildForm()) {//倒叙查询
                return this._findControl(dataField.substring(index + 1), form.get_parentForm(), false);
            }
            return control;
        }

        var items = dataField.split('.');
        var id = items[0];
        var tempControl = form[id];
        if (!tempControl) {
            //暂时不能找倒叙找带.的情况
            return;
        }
        if (tempControl instanceof Sys.UI.CustomForm) {
            control = this._findControl(dataField.substring(index + 1), tempControl, false);
        }
        if (tempControl instanceof Sys.UI.Controls.Grid) {
            control = tempControl.findColumn(items[1]);
        }
        if (tempControl instanceof Sys.UI.Controls.TreeGrid) {
            control = tempControl.findColumn(items[1]);
        }
        return control;
    },
    
    _getBusinessName:function(businessStr){
        try{
            businessStr = businessStr.replaceAll('\'', '"');
            return JSON.parse(businessStr).Name;
        } catch(e){
            return businessStr;
        }
    },

    //限定模式
    limit: function (resMaps, newData, oldData) {
        if (!resMaps) {
            return;
        }
        var form = this.action.get_form();
        var keys = Object.keys(resMaps);
        for (var i = 0; i < keys.length; i++) {
            var dataField = keys[i];
            var control = this._findControl(dataField, form, true);
            if (!control || !control.get_business()) {
                continue;
            }
            var businessControl = control[this._getBusinessName(control.get_business())];
            if (!businessControl) {
                continue;
            }

            var businessMethod = businessControl[resMaps[dataField]];
            if (!businessMethod) {
                continue;
            }
            businessMethod.apply(businessControl, [newData, oldData]);
        }
    },
    //注册控件
    registerToModel: function (businessControl) {
        this.action.$businessControls.push(businessControl);
        var form = this.action.get_form();
        if (!form.get_isChildForm()) {//判断是否是RUN产生的页面
            return;
        }
        var parentForm = form.get_parentForm();
        if (!parentForm) {
            return;
        }
        var parentAction = parentForm.get_action();
        if (!parentAction) {
            return;
        }
        if (!parentAction.$businessControls) {
            parentAction.$businessControls = [];
        }
        parentAction.$businessControls.push(businessControl);
    }
}
Sys.Control.BusinessControl = function () {
    this.control = null;
    this.businessModel = null;
    this._bindedEvents = {};
    this.businessData = {};//自定义数据
}
Sys.Control.BusinessControl.prototype = {
    bindActionAndControl: function (action, control, businessData) {
        this.control = control;
        this.businessModel = action.get_businessModel();
        this.businessModel.registerToModel(this);
        this.businessData = businessData;
        var controlInfo = this.controlInfo ? this.controlInfo() : '';
        if (!controlInfo) {
            return;
        }
        this._bindProperty(controlInfo.property);//绑定属性
        this._bindEvents(controlInfo.events);//绑定事件
    },
    disposing: function () {//回收
        if (this._bindedEvents) {
            var keys = Object.keys(this._bindedEvents);
            for (var i = 0; i < keys.length; i++) {
                var key = keys[i];
                this.control.get_events().removeHandler(key, this._bindedEvents[key]);
            }
        }
        if (this.control && this.control.remove_disposing) {
            this.control.remove_disposing(this.disposing);
        }
        if (this.control) {
            this.control._allEvents = null;
        }
        this.control = null;
        this.businessModel = null;
        this._bindedEvents = null;
    },
    _bindProperty: function (property) {
        if (!this.control || !property) {
            return;
        }

        var propertyKeys = Object.keys(property);
        for (var i = 0; i < propertyKeys.length; i++) {
            var propertyItem = propertyKeys[i];
            var setName = 'set_' + propertyItem[0].toLocaleLowerCase() + propertyItem.substring(1);
            if (this.control[setName] && typeof this.control[setName] == 'function') {
                this.control[setName](property[propertyItem]);
            }
        }
    },
    _bindEvents: function (events) {
        if (!this.control || !events) {
            return;
        }
        this.control.add_disposing(this.disposing);

        var eventKeys = Object.keys(events);

        if (!this.control._allEvents) {
            this.control._allEvents = {};
        }
        var changeEventName = ['focus', 'change','blur'];
        for (var i = 0; i < eventKeys.length; i++) {
            var eventItem = eventKeys[i];
            if (!eventItem.startsWith('On')) {
                throw new Error('绑定事件请用On开头, 如OnClick');
            }
            if (eventItem.length < 3) {
                throw new Error('事件名称错误');
            }
            var eventName = eventItem.substring(2);
            eventName = eventName[0].toLocaleLowerCase() + eventName.substring(1);
            if (changeEventName.indexOf(eventName) >= 0) {
                eventName = '_' + eventName;
            }
            var action = this.get_form().get_action();
            //当前gspx是否已经指定了这个事件，如果已经指定，直接用gspx的，不用业务控件的
            if (this.control._allEvents[eventName]) {
                if (!this.control.get_events().getHandler(eventName)) {
                    this.control.get_events().addHandler(eventName, this.control._allEvents[eventName]);
                }
                continue;
            }
            if (this.control.get_column) {
                var column = this.control.get_column();
                if (column && column._allEvents[eventName]) {
                    if (!this.control.get_events().getHandler(eventName)) {
                        this.control.get_events().addHandler(eventName, this.control._allEvents[eventName]);
                    }
                    continue;
                }
            }
            if (this.control.get_events().getHandler(eventName)) {//gspx已经定义了事件，就不加载业务控件的事件
                continue;
            }
            if (typeof events[eventItem] == "function") {
                this._bindedEvents[eventName] = Function.createDelegate(this, events[eventItem]);
                this.control.get_events().addHandler(eventName, this._bindedEvents[eventName]);
            } else if (typeof action[events[eventItem]] == "function") {
                this._bindedEvents[eventName] = Function.createDelegate(this, action[events[eventItem]]);
                this.control.get_events().addHandler(eventName, this._bindedEvents[eventName]);//导致双事件，先去掉(去掉有些事件会出无法响应的情况，先放开)
            }
            this.control._allEvents[eventName] = this._bindedEvents[eventName];
        }
        //列控件需要重新绑定下全局事件，方便列对应的编辑控件也可以得到相同的事件
        // if(this.control.get_grid && this.control.get_grid()){
        //     if(!this.control._allEvents){
        //         this.control._allEvents = {};
        //     }
        //     var keys = Object.keys(this._bindedEvents);
        //     for(var i = 0 ; i < keys.length ; i++){
        //         var key = keys[i];
        //         if(this.control._allEvents[key]){
        //             continue;//如果gspx存在，则用gspx的
        //         }
        //         this.control._allEvents[key] = this._bindedEvents[key];
        //     }
        // }
    },
    determine: function (resMaps, newData, oldData) {
        return this.businessModel.limit(resMaps, newData, oldData);
    },
    notify: function (responseMethodName, newData, oldData, orders) {
        return this.businessModel.bus(responseMethodName, newData, oldData, orders);
    },
    getEventPre:function(eventName){
        var id = '$';
        if (this.control.get_grid && this.control.get_grid()) {
            id += this.control.get_grid().get_id() + '$';
        }
        if (this.control.get_id()) {
            id += this.control.get_id() + '$';
        }
        if (this.control.get_dataField && this.control.get_dataField()) {
              var dataField = this.control.get_dataField();
            dataField = dataField.replace(/\./g, '_'); // ptype.usercode=>ptype_usercode
            id += dataField + '$';
        }
        return "_" + id + "_" + eventName;
    },
    bindControlEvent: function (eventName) {
        if (!this[eventName] || typeof this[eventName] != "function") {
            throw new Error(Object.getTypeName(this) + " 业务控件未找到方法 " + eventName);
        }
        var action = this.get_form().get_action();
        var newEventName = this.getEventPre(eventName);
        if (action[newEventName]) {
            return newEventName;
        }
        action[newEventName] = Function.createDelegate(this, eventName);
        return newEventName;
    },
    get_form: function () {
        if (!this.control) {
            return null;
        }
        return this.control.get_form();
    },
    get_service: function(){
        var form = this.get_form();
        if(!form){
            return null;
        }
        return form.get_action().get_service();
    }
}

Sys.Control.BusinessControl.registerClass("Sys.Control.BusinessControl");
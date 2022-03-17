class List {}
class Stack extends List {}

//
class Stack {
    constructor() {
        this._storage = new List();
    }
}
class List {}

//
class CatalogItem {
    constructor(id, title, tags) {
        this._id = id;
        this._title = title;
        this._tags = tags;
    }
    get id() {return this._id;}
    get title() {return this._title;}
    hasTag(arg) {return this._tags.includes(arg);}
}

class Scroll extends CatalogItem {
    constructor(id, title, tags, dateLastCleaned) { 
        super(id, title, tags);
        this._lastCleaned = dateLastCleaned;
    }
    needsCleaning(targetDate) {
        const threshold = this.hasTag("revered") ? 700 : 1500; 
        return this.daysSinceLastCleaning(targetDate) > threshold;
    }
    daysSinceLastCleaning(targetDate) {
        return this._lastCleaned.until(targetDate, ChronoUnit.DAYS); 
    }
}

class Scroll {
    constructor(id, title, tags, dateLastCleaned) {
        this._id = id;
        this._catalogItem = new CatalogItem(id, title, tags);
        this._lastCleaned = dateLastCleaned;
    }
    get id() {return this._id;}
    get title() {return this._catalogItem.title;} 
    hasTag(aString) {return this._catalogItem.hasTag(aString);}
}

class Scroll {
    constructor(id, dateLastCleaned, catalogID, catalog) {
        this._id = id;
        this._catalogItem = catalog.get(catalogID);
        this._lastCleaned = dateLastCleaned;
    }
    get id() {return this._id;}
    get title() {return this._catalogItem.title;} 
    hasTag(aString) {return this._catalogItem.hasTag(aString);}
}
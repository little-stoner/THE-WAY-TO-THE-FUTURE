package com.apollo.moon;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent configChangeEvent) {
        System.out.println("before: >>>>");
        System.out.println(configChangeEvent.changedKeys());
        System.out.println(configChangeEvent.getChange("url"));
        System.out.println("after: <<<<");
    }

}

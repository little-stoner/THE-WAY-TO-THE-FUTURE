package com.kickoff;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;

public class BootStrap implements BootstrapRegistryInitializer {

    @Override
    public void initialize(BootstrapRegistry registry) {
        System.out.println(" >>>>>>>>>>>>>. Custom Initialization ");
    }

}

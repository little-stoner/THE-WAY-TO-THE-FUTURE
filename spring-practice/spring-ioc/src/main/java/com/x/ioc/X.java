package com.x.ioc;

public class X {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "X{" +
                "name='" + name + '\'' +
                '}';
    }
}

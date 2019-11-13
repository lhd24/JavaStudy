package com.study.baseEnhance.annotation;

public interface DemoInterface {
    public abstract String ShowDemo1();

    String ShowDemo2();

    /**
     * 默认实现
     * @return
     */
    default String ShowDemo3(){
        return "";
    }
}

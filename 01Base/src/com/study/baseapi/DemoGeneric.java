package com.study.baseapi;

import java.util.ArrayList;
import java.util.Collection;

public class DemoGeneric {
    public static void main(String[] args) {
        //test1();

    }

    private void test1() {
        //MyGenericClass2<String> a = new MyGenericClass2();    //出错 提示需implement Collection
        MyGenericClass2<ArrayList> a = new MyGenericClass2<ArrayList>();
    }

    /**
     * 方法泛型
     * @param mvp
     * @param <T>
     */
    public <T> void show(T mvp) {
        System.out.println(mvp.getClass());
    }

    /**
     * 泛型类
     * @param <T>
     */
    public class MyGenericClass<T> {
        //没有MVP类型，在这里代表 未知的一种数据类型 未来传递什么就是什么类型
        private T mvp;

        public void setMVP(T mvp) {
            this.mvp = mvp;
        }

        public T getMVP() {
            return mvp;
        }
    }

    /**
     * 泛型类 约束
     * @param <T>
     */
    public  class MyGenericClass2<T extends Collection> {
        //没有MVP类型，在这里代表 未知的一种数据类型 未来传递什么就是什么类型
        private T mvp;

        public void setMVP(T mvp) {
            this.mvp = mvp;
        }

        public T getMVP() {
            return mvp;
        }
    }

    /**
     * 泛型接口
     * @param <E>
     */
    public interface MyGenericInterface<E>{
        public abstract void add(E e);

        public abstract E getE();
    }

    /**
     * ？代表可以接收任意类型
     * @param coll
     */
    public static void getElement(Collection<?> coll){}

    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}

}

package com.source.javalang.classtest;

import java.lang.reflect.Modifier;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/21
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("java.lang.Thread");

        try {
            Thread thread = (Thread) c.newInstance();
            System.out.println(thread.getClass().toGenericString());
            /**
             * Modifier.classModifiers() 采用16进制的方式，对class的修饰符进行枚举组合。
             * 通过'|'和'&'的方式，得到class的修饰符
             */
            System.out.println(Modifier.classModifiers());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(Class.forName("java.lang.annotation.Annotation").toGenericString());
    }
}

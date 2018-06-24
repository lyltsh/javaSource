package com.source.javalang.classtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/21
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("java.lang.Thread");
        System.out.println(c.getSimpleName());
        System.out.println(c.getTypeName());
        ClassLoader classLoader = c.getClassLoader();
        //Bootstrap classloader
        System.out.println(classLoader);

        Class<?>[] interfaces = c.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
            System.out.println(interfaces[i].getModifiers());
            System.out.println(interfaces[i].getComponentType());
        }
        System.out.println("methods start==================================");

        Method[] methods = c.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        System.out.println("fields start=====================================");
        Field[] fields = c.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        System.out.println("constructor start=====================================");
        Constructor[] constructors = c.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        System.out.println("constructor end=====================================");

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

        Class<?> pc = Class.forName("com.source.javalang.classtest.PrivateCon");
        System.out.println(pc.toGenericString());
        System.out.println(pc.getGenericSuperclass());
        System.out.println(pc.getPackage());
//        try {
//            PrivateCon privateCon = ((PrivateCon) pc.newInstance());
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}

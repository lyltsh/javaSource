package com.source.javalang.reflecttest.methodtest;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/24
 */
public class MethodDemo implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.source.javalang.reflecttest.methodtest.Circle");
        //根据参数获取public的method，包含继承父类的方法
        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method:" + method);

        //获取所有public的方法，包括父类的方法
        Method methods[] = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("=======================");
        //获取当前类的方法包含private，该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1: " + method1);
        //获取当前类的所有方法，包含private，但是无法获取继承自父类的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }

        //通过method类调用制定类的方法
        Circle circle = (Circle) clazz.newInstance();
        //获取指定参数的方法对象method
        Method method2 = clazz.getMethod("draw", int.class, String.class);
        //通过Method的invoke方法方法调用
        method2.invoke(circle, 20, "234");

        //对私方法的操作
        Method method3 = clazz.getDeclaredMethod("drawCircle");
        method3.setAccessible(true);
        method3.invoke(circle);

        //对有返回值得方法操作
        Method method4 = clazz.getDeclaredMethod("getAllCount");
        method4.setAccessible(true);
        Integer count = (Integer) method4.invoke(circle);
        System.out.println("count:" + count);
    }
}

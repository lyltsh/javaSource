package com.source.javalang.reflecttest.arraytest;

import java.lang.reflect.Array;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/24
 */
public class ArrayDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //获取数组类型的Class
        Class<?> clazz = array.getClass().getComponentType();
        //创建一个具有指定的组件类型和长度的新数组
        //第一个参数：数组的类型；第二个参数：数组的长度
        Object newArr = Array.newInstance(clazz, 15);
        //获取原数组的长度
        int co = Array.getLength(array);
        //赋值原始数组到新数组
        System.arraycopy(array, 0, newArr, 0, co);
        for (int i : (int[]) newArr) {
            System.out.println(i);
        }

        //创建一个长度为10的字符串数组
        //接着把索引位置为6 的元素设为"hello world!"，然后再读取索引位置为6 的元素的值
        Class<?> clazz2 = Class.forName("java.lang.String");
        Object array2 = Array.newInstance(clazz2, 10);
        Array.set(array2, 6, "hello world");
        String str = (String) Array.get(array2, 6);
        System.out.println(str);
        for (String s : (String[]) array2) {
            System.out.println(s);
        }
        System.out.println("==============================");
        min(toIntegerArray(array));
    }

    /**
     * 接收一个泛型数组，然后创建一个长度与接收的数组长度一样的泛型数组，
     * 并把接收的数组的元素复制到新创建的数组中，
     * 最后找出新数组中的最小元素，并打印出来
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void min(T[] a) {
        //通过反射的方式创建一个长度与接收的数组长度一样的泛型数组
        Class<?> clazz = a.getClass().getComponentType();
        T[] b = (T[]) Array.newInstance(clazz, a.length);
        System.arraycopy(a, 0, b, 0, a.length);
        T min = null;
        boolean flag = true;
        for (int i = 0; i < b.length; i++) {
            if (flag) {
                min = (T)Array.get(b, i);
//                min = b[i];
                flag = false;
            }
            if (b[i].compareTo(min) < 0) {
                min = b[i];
            }
        }
        System.out.println("min:" + min);
    }

    /**
     * int数组转成Integer数组
     *
     * @param a
     * @return
     */
    public static Integer[] toIntegerArray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Integer[] integers = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            integers[i] = Integer.valueOf(a[i]);
        }
        return integers;
    }
}

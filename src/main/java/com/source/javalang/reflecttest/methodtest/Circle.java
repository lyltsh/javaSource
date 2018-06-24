package com.source.javalang.reflecttest.methodtest;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/24
 */
public class Circle extends Shape {
    private void drawCircle() {
        System.out.println("drawCircle");
    }

    private int getAllCount() {
        return 100;
    }
}

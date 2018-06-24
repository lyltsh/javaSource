package com.source.javalang.reflecttest.methodtest;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/24
 */
public class Shape {
    public void draw() {
        System.out.println("draw");
    }

    public void draw(int count, String name) {
        System.out.println("draw " + name + ",count=" + count);
    }
}

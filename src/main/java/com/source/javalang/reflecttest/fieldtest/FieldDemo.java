package com.source.javalang.reflecttest.fieldtest;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/23
 */
public class FieldDemo implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.source.javalang.reflecttest.fieldtest.Student");
        //获取指定名称的Field类，修饰符必须为public而且存在该字段
        Field field = clazz.getField("age");
        System.out.println("field:" + field);

        //获取所有修饰符为public的字段，包括父类字段，只有修饰符为public的才能获取
        Field fields[] = clazz.getFields();
        for (Field f : fields) {
            System.out.println("f:" + f);
        }

        System.out.println("=======================");
        //获取当前类所有字段（包含private字段），注意不包含父类的字段
        Field field1 = clazz.getDeclaredField("desc");
        System.out.println("field1:" + field1);

        //对指定域赋值
        Student student = (Student) clazz.newInstance();
        //获取父类public字段并赋值
        Field ageField = clazz.getField("age");
        ageField.set(student, 23);
        Field nameField = clazz.getField("name");
        nameField.set(student, "lily");
        System.out.println("student:" + student);

        //只获取当前类的字段，不获取父类字段
        Field descField = clazz.getDeclaredField("desc");
        descField.setAccessible(true);
        descField.set(student, "i am student");
        Field scoreField = clazz.getDeclaredField("score");
        scoreField.setAccessible(true);
        scoreField.set(student, 90);
        System.out.println("student:" + student);
        //获取字段值
        System.out.println(scoreField.get(student));
    }
}

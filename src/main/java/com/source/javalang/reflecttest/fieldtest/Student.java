package com.source.javalang.reflecttest.fieldtest;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/23
 */
public class Student extends Person {
    private String desc;
    private final int score = 0;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

//    public void setScore(int score) {
//        this.score = score;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "desc='" + desc + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.hq.java;

import java.io.Serializable;

/**
 * @author huqi
 * @creat 2020-03-24 21:20
 * @description
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private double math;
    private double english;

    public Student(String id, String name, double math, double english) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
    }

    public Student() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}

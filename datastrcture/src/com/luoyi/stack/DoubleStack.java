package com.luoyi.stack;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/18
 * <p>
 * 两栈共享空间
 * 适用于一个栈增加一个栈减少
 */
public class DoubleStack {

    int top1;  // 第一个栈空间的栈顶
    int top2;  // 第二个栈空间的栈顶
    public static final int MAXIZE = 10;
    Object[] data;

    public DoubleStack() {
        this.data = new Object[MAXIZE];
        this.top1 = -1;
        this.top2 = MAXIZE - 1;
    }


    /** 增
     *
     * @param num
     * @param o
     */
    public void push(int num, Object o) {

        if (top1 + 1 == top2) {
            System.out.println("栈已满");
            return;
        }

        if (num == 1) {
            top1++;
            data[top1] =  o;
        }
        if (num == 2) {
            data[top2] =  o;
            top2--;
        }
    }

    /**删除
     *
     */
    public Object pop(int num,Object o ){
        if (num == 1) {
            if (top1 == -1){
                System.out.println("空栈");
                return false;
            }
            o = data[top1];
            top1--;

        }
        if (num == 2) {
            if (top2 == MAXIZE -1){
                System.out.println("已到达栈顶");
            }
            o = data[top2];
            top2++;
        }
        return o;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoubleStack{");
        sb.append("top1=").append(top1);
        sb.append(", top2=").append(top2);
        sb.append(", data=").append(Arrays.toString(data));
        sb.append('}');
        return sb.toString();
    }
}

class Student{
    private String name ;
    private int age ;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}

class Test2{
    public static void main(String[] args) {
        Student stu1 = new Student("张三",12);
        Student stu2 = new Student("李四",18);
        DoubleStack ds = new DoubleStack();

        ds.push(1,stu1);
        ds.push(1,stu2);
        ds.push(2,stu2);

        System.out.println(ds);
    }
}
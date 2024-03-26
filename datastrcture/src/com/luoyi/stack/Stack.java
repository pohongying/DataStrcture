package com.luoyi.stack;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/18
 * <p>
 * 实现栈的基本功能
 * 用于递归
 */
public class Stack {

    int up;

    public static final int MAXIZE = 10;
    int[] data;


    /**
     栈顶为-1的时候为栈为空
     * @return: null
     * @author: luoyi
     * @date: 2024/2/18 22:59
     */
    public Stack() {
        this.data = new int[MAXIZE];
        this.up = -1;
    }

    /**
     * 增
     */
    public void push(int o) {
        // 是否超出栈的最大值
        if (up == MAXIZE-1) {
            System.out.println("超出栈的最大值");
            return;
        }
        up++;
        data[up] =  o;

    }

    /** 减
     * todo 实际上并没有真正删除
     */
    public Object pop(){
        if (up == -1){
            System.out.println("已经到达栈底！");
            return false;
        }
        int o = data[up];
        up--;
        return  o;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stack{");
        sb.append("up=").append(up);
        sb.append(", data=").append(Arrays.toString(data));
        sb.append('}');
        return sb.toString();
    }
}

class  Test1{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        Object pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);
    }
}


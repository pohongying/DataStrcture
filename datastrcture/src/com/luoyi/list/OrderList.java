package com.luoyi.list;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * <p>
 * 线性表的顺序存储
 * @Date 2024/2/12
 */
public class OrderList {

    // 设置数组长度
    public static final int MAXSIZE = 10;

    // 数组的实际长度
    int length;

    int[] array;

    /**
     * 初始化
     *
     * @param
     */
    public OrderList() {
        this.array = new int[MAXSIZE];
        this.length = 0;
    }

    /**
     * 获取长度
     */
    public int getLength() {
        return length;
    }


    /**
     * 增，即插入
     * <p>
     * param: i插入的位置，num 插入的数
     */
    public void insert(int i, int num) {

        if (i > length || i < 0) {
            System.out.println("插入的位置不对");
            return;
        }
        if (i >= MAXSIZE) {
            throw new OutOfMemoryError("超出最大范围");
        }


        for (int j = length ; j > i; j--) {
            array[j] = array[j-1];

        }
        array[i] = num;
        length++;
        System.out.println(Arrays.toString(array));



    }

    /** 删除
     *
     */

    public void delete(int i){

        if (i > length || i < 0) {
            System.out.println("删除的位置不对");
            return;
        }
        if (i >= MAXSIZE) {
            throw new OutOfMemoryError("超出最大范围");
        }
        for (int j = i; j < array.length-1; j++) {
            array[j] = array[j+1];
        }
        System.out.println(Arrays.toString(array));

    }

    /** 找到某个值相对于的索引
     *
     */

    public int getLen(int value){
        for (int i = 0; i < length; i++) {
            if (array[i] == value){
                return  i ;
            }

        }
        return -1;
    }



}


class TestList {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        orderList.insert(0,23);
        orderList.insert(1,211);
        orderList.insert(2,985);
        orderList.insert(3,11);
        orderList.insert(4,22);
        orderList.insert(5,33);
        orderList.insert(4,44);

        orderList.delete(3);

        int len = orderList.getLen(985);
        System.out.println(len);
    }

}
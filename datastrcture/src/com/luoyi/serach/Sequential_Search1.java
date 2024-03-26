package com.luoyi.serach;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/27
 *
 * 顺序查找
 */
public class Sequential_Search1 {

    public static void main(String[] args) {

        int [] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int search = search(arr, 10000, 5000);
        System.out.println(search);
    }

    static int search(int [] a , int n, int key) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] == key){
                return i;
            }
        }

        return 0;

    }
}
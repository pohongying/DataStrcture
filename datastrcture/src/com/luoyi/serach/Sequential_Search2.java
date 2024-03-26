package com.luoyi.serach;


/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/27
 */
public class Sequential_Search2 {

    public static void main(String[] args) {

        int [] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int search = search(arr, 10000, 5000);
        System.out.println(search);
    }

    static int search(int[] a, int n, int key) {

        // todo 有点不用一直比较i<n，不过时间复杂度一样
     while (a[n-1] != key){
         n--;
     }
     return n;

    }
}
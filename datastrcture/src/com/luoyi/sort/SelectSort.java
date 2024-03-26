package com.luoyi.sort;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/4
 * <p>
 * 简单选择排序
 */
public class SelectSort {


    int[] sqList;
    static final int MAXIZE = 10;

    public SelectSort() {
        this.sqList = new int[MAXIZE];
    }

    public static void swap(int[] L, int i, int j) {
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;

    }

    public static int[] selectSort(int[] L) {

        int min;
        for (int i = 0; i < L.length; i++) {
            min = i;
            for (int j = i + 1; j < L.length; j++) {
                if (L[min] > L[j]){
                    min = j ;
                }
                if (i != min){  // todo i = 1,2,3
                    swap(L,i,min);    // 当没有找到最小的那个值，就交换  1，2,3，4
                }

            }
        }
        return L;

    }

    public static void main(String[] args) {
        new SelectSort();
        int[] arr = {2, 1, 4, 10, 11, 3, 7, 6, 9, 8};
        System.out.println(Arrays.toString(selectSort(arr)));
    }
}
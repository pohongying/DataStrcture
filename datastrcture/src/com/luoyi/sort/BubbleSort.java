package com.luoyi.sort;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/4
 * <p>
 * 冒泡排序
 */
public class BubbleSort {

    int[] sqList;
    static final int MAXIZE = 10;

    public BubbleSort() {
        this.sqList = new int[MAXIZE];
    }

    public static void swap(int[] L, int i, int j) {
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;

    }

    // TODO: 2024/3/4  最简单的一种交换，速度相对较慢
    public static int[] bubbleSort0(int[] L) {

        for (int i = 0; i < L.length; i++) {

            for (int j = i + 1; j < L.length; j++) {

                if (L[i] > L[j]) {
                    swap(L, i, j);  // todo 有点类似于递推
                }

            }
        }
        return L;

    }

    // todo  较小的数就像是泡泡一样缓慢的冒出来
    public static int[] bubbleSort1(int[] L) {
        for (int i = 0; i < L.length; i++) {

            for (int j = L.length - 1; j > i; j--) {

                if (L[j - 1] > L[j]) {
                    swap(L, j, j + 1);
                }

            }
        }
        return L;
    }

    // flag 标记变量
    public static int[] bubbleSort2(int[] L) {
        boolean flag = true;
        for (int i = 0; i < L.length && flag; i++) {

            flag = false;
            for (int j = L.length - 1; j > i; j--) {

                if (L[j - 1] > L[j]) {
                    swap(L, j, j -1);
                    flag = true;
                }

            }
        }
        return L;
    }

    public static void main(String[] args) {
        new BubbleSort();
        int[] arr = {2, 1, 4, 10, 11, 3, 7, 6, 9, 8};
//        System.out.println(Arrays.toString(bubbleSort0(arr)));
        System.out.println(Arrays.toString(bubbleSort2(arr)));
    }

}



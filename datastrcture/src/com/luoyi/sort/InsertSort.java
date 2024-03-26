package com.luoyi.sort;

/**
 * @Description 插入排序
 * @Author Luoyi
 * @Date 2024/3/5
 */
public class InsertSort {

    public static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int current = a[i];   // 要插入的数
            int j = i - 1;   // 插入的位置

            while (j >= 0 && a[j] > current) {  //  找到插入的位置
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = current;
        }

        return a;
    }


    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        int[] sortedArr = insertSort(arr);

        // 打印排序后的数组
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }
}

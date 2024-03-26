package com.luoyi.leetcode.sort;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/26
 * <p>
 * 合并两个有序数组
 * 条件：1. 递增或者递减的数组
 *      2. 合并到其中一个数组中
 */
public class Sort_Test07 {
    public static void main(String[] args) {
        int[] nums1 = {5, 6, 7, 8, 9, 0, 0, 0, 0, 0};
        int[] nums2 = {3, 4, 5, 6, 7};

        merge(nums1, 5, nums2, 5);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // TODO: 2024/3/26  定义三个指针  感觉自定义指针通常用while
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        /**
         * 判断条件为，把nums2数组全添加进去即可
         */
        while (j >= 0) {
            /**
             * 当nums1的元素已经全部排完，或者nums2[j] > nums1[i])
             */
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
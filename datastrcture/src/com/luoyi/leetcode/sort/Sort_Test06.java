package com.luoyi.leetcode.sort;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/25
 *
 * 颜色分类
 */
public class Sort_Test06 {
    public static void main(String[] args) {
        int [] nums = {2,1,0,0,2,1,1};
        sortColors1(nums);
    }

    // 时间复杂度为o(n^2)
    public  static void sortColors(int[] nums) {
        // 简单的冒泡排序
        boolean flag = true;
        for(int i = 0; i< nums.length && true;i++){
            flag = false;
            for(int j = nums.length-1; j>i;j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void sortColors1(int[] nums) {
        // 这是第二种方法
        int n = nums.length;
        int ptr = 0;        // 指针指向当前的已经排好的位置的下一个

        // 把0排到最前面
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        // 然后再把1排到后面
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }

        }
        System.out.println(Arrays.toString(nums));

    }
}
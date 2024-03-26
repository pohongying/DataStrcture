package com.luoyi.leetcode.sort;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/21
 *
 * 最接近三数之和
 *
 * 思想：1. 双指针
 *      2. 先排序后比较
 *      3. 找到最小值
 */
public class Sort_Test02 {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = threeSumClosest(arr,1);
        System.out.println(n);

    }

    public  static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // 如果正好能找到这个值，则返回
                    return target;
                }
            }
        }

        return closestSum;
    }

}
package com.luoyi.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/21
 *
 * 四数之和
 */
public class Sort_Test03 {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + " ");
        }
    }


    // TODO: 2024/3/21
    //  1. 确立前面两个基准值
    //  2.去重
    //  3. 考虑溢出，溢出要用long
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        // 1. 先排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        // 2. 确定基准值，双指针
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    // TODO: 2024/3/21  溢出的时候考虑long类型 
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        List l = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        list.add(l);

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
package com.luoyi.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/20
 * <p>
 * 求三数之和
 */


public class Sort_Test01 {
    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum1(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < lists.size(); i++) {
                System.out.print(lists.get(i)+" ");
            }




    }

    // TODO: 2024/3/20 双指针
    // todo ： 根据num的取值，来移动左指针还是右指针,固定一个数，动其他两个数，确定基准值
    //  先排序后去重很关键

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();

        Arrays.sort(nums); // 排序数组，方便后续处理

        // 固定一个数，然后用双指针查找剩下两个数
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 避免重复

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    allList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 避免重复
                    while (left < right && nums[left] == nums[left + 1]) left++;   // todo 这避免重复的代码很重要，可能有多个重复
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;             // todo 不管有没有找到都要移动指针
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return allList;
    }

    // todo 这种是枚举的办法，o(n^3),耗时大，注意去重
    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> allList = new  ArrayList<>();

        Arrays.sort(nums);

        // 1.用简单的办法
        for(int i = 0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;  // 去重   // TODO: 2024/3/20 学到了用continue来实现去重 

            for(int j = i+1; j< nums.length-1;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue; // 去重

                for(int k = j+1; k<nums.length;k++){
                    if(k>j+1&&nums[k]==nums[k-1])continue;  // 去重
                    
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        allList.add(list);
                    }
                }
            }
        }
        return allList;

    }
}


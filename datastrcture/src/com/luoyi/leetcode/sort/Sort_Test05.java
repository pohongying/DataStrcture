package com.luoyi.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/21
 * <p>
 * 合并区间
 */
public class Sort_Test05 {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int[] list :
                merge) {
            for (int i :
                    list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }


    public static int[][] merge(int[][] intervals) {

        if(intervals.length == 0){
            return new int [0][2];
        }

        /**
         * 先排序
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        /**
         * 合并数组，即是创建一个新的列表活数组添加进行
         */
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int a = intervals[i][0];   // 第一个数
            int b = intervals[i][1];   // 第二个数

            int len = list.size();
            if (list.size() == 0 || list.get(len - 1)[1] < a) {
                list.add(new int[]{a ,b});
            } else {
                list.get(len - 1)[1] = Math.max(list.get(len - 1)[1], b);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
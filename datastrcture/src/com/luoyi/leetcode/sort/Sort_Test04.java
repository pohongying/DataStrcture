package com.luoyi.leetcode.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/21
 *
 * 字母异位分组
 */
public class Sort_Test04 {
    public static void main(String[] args) {
       String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.toString(strs));
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list:
             lists) {
            System.out.println(list);    // // TODO: 2024/3/21  list可以直接打印
        }

    }


    public static List<List<String>> groupAnagrams(String[] strs) {

        // 建立一个Map集合用来根据key,来添加到列表
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // String 转 char的目的是为了排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String newStr = new String(chars);

            // 将排序好的字符串添加到map集合中
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList());
            }
            // 将排序之前的字符串添加到列表中
            map.get(newStr).add(str);

        }

        return new ArrayList<>(map.values());

    }

}
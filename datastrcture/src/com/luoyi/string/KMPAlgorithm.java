package com.luoyi.string;

import java.util.Arrays;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/21
 * <p>
 * 实现kmp算法
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";

        int[] kmpNext = getKmpNext("ABCDABD");
        System.out.println(Arrays.toString(kmpNext));

        int kmpSearch = getKmpSearch(s1, s2, kmpNext);
        System.out.println("index:"+kmpSearch);


    }

    /**
     * @param dest:
     * @return: int[]
     * @author: luoyi
     * @date: 2024/2/21 14:14
     */
    public static int[] getKmpNext(String dest) {  // 要匹配的字符串

        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {


            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {  // TODO: 2024/2/21 这里注意一定要用while
                j = next[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {  // TODO: 2024/2/21  相等的话，j和i 都移动
                j++;
            }
            // TODO: 2024/2/21

            next[i] = j; // TODO: 2024/2/21  给next赋值了
        }
        return next;

    }

    public static int getKmpSearch(String s1, String s2, int[] next) {

        for (int i = 0, j = 0; i < s1.length(); i++) {

            // TODO: 2024/2/21  这句是关键 ！！
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }


            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }

            if (j == s2.length()) {
                System.out.println("已经找到");
                return i - j+1;

            }

        }
        return -1;
    }


}
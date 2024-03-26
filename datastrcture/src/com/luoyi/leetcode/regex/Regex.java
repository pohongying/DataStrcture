package com.luoyi.leetcode.regex;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/26
 * 正则表达式
 */
public class Regex {
    public static void main(String[] args) {
        Solution s = new Solution();
    }

}

class Solution {
    public boolean isMatch(String s, String p) {

        for (int i = 0 ,  j = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*' || p.charAt(i) != '.'){
                    if (s.charAt(j)!= p.charAt(i)){
                        return  false;
                    }
                    if (p.charAt(i) == '*'){

                    }
        }

        }
        return  false;
    }

}
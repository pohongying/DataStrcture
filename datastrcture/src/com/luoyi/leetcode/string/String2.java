package com.luoyi.leetcode.string;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/7
 * <p>
 * 找出字符串的可整除数组
 *
 * 总结：1. 遇到大数的运算，容易溢出，找到一种办法变成小点的数
 */
public class String2 {


    public int[] divisibilityArray(String word, int m) {

        int[] res = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // todo   就不用转换成数组了
            cur = (cur * 10 + (c - '0')) % m;  // TODO: 2024/3/7  这一步非常关键，余数=(前方的余数*10+后面的余数 ) 取余
            System.out.println("循环第"+i+"次："+cur);
            res[i] = (cur == 0) ? 1 : 0;
        }
        return res;
    }
}



class String2_test {
    public static void main(String[] args) {
        String word = "998244353";
        int m = 3;
        String2 s = new String2();
        int[] ints = s.divisibilityArray(word, m);


        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            if (i < ints.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
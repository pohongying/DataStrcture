package com.luoyi.leetcode.recur;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/9
 * <p>
 * 外观数列：
 * 给一个数，这个数是1
 * 描述上一步的数，这个数是 1 即一个1，故写作11
 * 描述上一步的数，这个数是11即两个1，故写作21
 * 描述上一步的数，这个数是21即一个2一个1，故写作12-11
 * 描述上一步的数，这个数是1211即一个1一个2两个1，故写作11-12-21
 */

public class Recur2 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1); // 获取前一项的外观数列
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char currentChar = prev.charAt(0);

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(count);
                sb.append(currentChar);
                currentChar = prev.charAt(i);
                count = 1;
            }
        }

        // 处理最后一个字符的计数
        sb.append(count);
        sb.append(currentChar);

        return sb.toString();
    }

    public static void main(String[] args) {
        Recur2 recur2 = new Recur2();
        System.out.println(recur2.countAndSay(5)); // 输出应该是 "111221"
    }
}
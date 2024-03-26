package com.luoyi.leetcode.string;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/3/11
 * <p>
 * 将标题首字母大写
 */
public class String1 {

    /**题目：
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title 。
     */

// todo 这道题理解错误，导致努力白费

    /**
     * @param title:
     * @return: java.lang.String
     * @author: luoyi
     * @date: 2024/3/11 20:15
     * 1. 拆成字符串数组
     * 2. 判断是否大于或者小于等于2，
     * 大于2的首字母大写---利用substring分割,touppercase
     * 小于2全部小写---利用tolowercase
     */
    public static String capitalizeTitle(String title) {

        String[] arr = title.split(" ");   // todo  转换车成字符串数组
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            if (len < 2) {
                arr[i] = arr[i].toLowerCase();
            }
            if (len > 2) {
                String s1 = arr[i].substring(0, 1).toUpperCase();
                String s2 = arr[i].substring(1).toLowerCase();
                arr[i] = s1 + s2;
            }

        }
        str = String.join(" ", arr);  // TODO: 2024/3/11  学会了一个新招
//        for (int j = 0; j < arr.length; j++) {
//            str += arr[j];
//            if (j < arr.length) {
//                str += " ";
//            }
        return str;

    }


    public static String capitalizeTitle1(String title) {
        StringBuilder ans = new StringBuilder()  ; // 可以频繁改变字符串
        String[] arr = title.split(" ");

        for (String s : arr) {   // 增强for循环遍历数组
            if (ans.length() > 0){
                ans.append(" ");   // todo  添加空格(包头不包尾)
            }
            if (s.length() > 2) {
                ans.append(s.substring(0, 1).toUpperCase()); // 首字母大写
                s = s.substring(1); // 将字符串后面的部分装换成小写
            }
            ans.append(s.toLowerCase());   // 拼接上

        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        String t1 = "Hello woRLD niHao Shhi";
        String t2 = "ASF DSFsd";
        String s = capitalizeTitle1(t2);
        System.out.println(s);
    }
}
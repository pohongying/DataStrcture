package com.luoyi.leetcode.palindrome;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/26
 * <p>
 * 回文数 反转之后还相等的数
 */
public class palindrome {
    public static void main(String[] args) {


//        Solution s = new Solution();
//        s.isPalindrome(123);

        Solution1 s1 = new Solution1();
        System.out.println(s1.isPalindrome(121));
//        System.out.println(s1.isPalindrome(123));

    }


}

//todo 方法一
class Solution {

    /* 利用数学公式进行反转比较解决
     */
    public boolean isPalindrome(int x) {

        int num = 0;
        int temp = x;
        while (x != 0) {
            num = num * 10;
            num = num + x % 10;
            x = x / 10;
        }
        if (num != temp) {
            return false;
        }
        return true;

    }

}

// todo 方法二

class Solution1 {

    /* 利用数学公式进行反转比较解决，全部进行比较
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int temp = x;
        while (x != 0) {
            num = num * 10;
            num = num + x % 10;
            x = x / 10;
        }
        if (num != temp) {
            return false;
        }
        return true;

    }

}


// todo 方法三

class Solution2 {

    /* 利用数学公式进行反转比较解决，只比较一半，而不是都去比较
     */
    public boolean isPalindrome(int x) {

        if (x < 0 ||(x % 10 == 0 && x != 0) ){
            return false;
        }
        int num = 0;
        while (x > num) {  // TODO: 2024/2/26   判断条件
            num = num * 10;
            num = num + x % 10;
            x = x / 10;
        }
        return x == num || x == num / 10;  //todo 因为可能 可能刚好是奇数，会比x多一个数

    }

}



package com.luoyi.serach;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/29
 * <p>
 * 斐波那契查找（黄金分割查找)
 */
public class FibonacciSearch {

    static  int[] f;

    public FibonacciSearch() {
        f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }

    public static int fibSearch(int[] a, int n, int key) {

        int low, mid, high, k;
        low = 1;
        high = n;
        k = 0;
        while (n > f[k]){
            k++;
        }
        for (int i = n; i < f[k] - 1; i++) {
             a[i] = a[n] ;

        }

        while (low <= high){

            mid = low + f[k-1] -1 ;


            if (key <a[mid]){
                high = mid - 1;
                k = k -1 ;
            }else if(key > a[mid]){
                low = mid + 1 ;
                k = k -2;
            }else {
                if (mid < n){
                    return mid ;
                }else{
                    return  n ;
                }
            }
        }
        return  0 ;
    }

    public static void main(String[] args) {
        FibonacciSearch fs = new FibonacciSearch();
        int [] a = {23,345,5,2,43,123,19,12,35};
        int i = fibSearch(a, 8, 2);
        System.out.println(i);
    }

}
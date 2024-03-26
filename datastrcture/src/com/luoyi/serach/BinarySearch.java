package com.luoyi.serach;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/27
 *
 * 二分查找，又叫折半查找
 */
public class BinarySearch {

    public static void main(String[] args) {

        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int i = binarySearch(arr, 99, 46);
        System.out.println(i);
    }
    public static int binarySearch(int [] arr,int  n, int key){

        // TODO: 2024/2/27  指的是数组下标的索引
        int low = 0;
        int mid ;
        int upper = n;

        while (low <= upper){
            mid = (low+upper)/2;  // mid = low + (upper-low)/2
            if (key<arr[mid]){
                upper = mid -1 ;
            }
            else if (key > arr[mid]){
                low = mid +1 ;
            }
            else {
                return mid;
            }

        }
        return  0 ;
    }


    public static int newBinarySearch(int [] arr,int  n, int key){

        // TODO: 2024/2/27  指的是数组下标的索引
        int low = 0;
        int mid ;
        int upper = n;

        while (low <= upper){
            mid = low + (key-arr[low])/(arr[upper]-arr[low]);  // TODO: 2024/2/27  根据实际占比来计算
            if (key<arr[mid]){
                upper = mid -1 ;
            }
            else if (key > arr[mid]){
                low = mid +1 ;
            }
            else {
                return mid;
            }

        }
        return  0 ;
    }


}


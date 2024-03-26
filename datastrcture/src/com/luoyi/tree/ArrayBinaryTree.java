package com.luoyi.tree;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/22
 *
 * 顺序二叉树 ，通常是完全二叉树
 */

public class ArrayBinaryTree {
    private int [] array;

    public ArrayBinaryTree(int [] arr){
        this.array =  arr;

    }

    public void preOrder(int index){


        if (array == null && array.length == 0){
            System.out.println("数组为空或者空指针");
        }
        System.out.println(index);

        if (index*2+1 < array.length){    // TODO: 2024/2/22  这运用了数学运算 
            this.preOrder(index*2+1);
        }
        if (index*2+2 < array.length)
            this.preOrder(index*2+2);

    }

}
class ArrayBinaryTreeDemo{
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        abt.preOrder(0);
    }
}

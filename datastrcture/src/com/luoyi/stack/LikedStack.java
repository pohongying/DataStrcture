package com.luoyi.stack;

/**
 * @Description 链栈的实现
 * @Author Luoyi
 * @Date 2024/2/19
 *
 * 没有内存的限制，类似于链表   只需要一个栈顶tpo指针
 */

// TODO: 2024/2/19  注意只要是链式存储记得一定要定义节点！！！
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedStack {
    private Node top; // 栈顶节点

    public LinkedStack() {
        this.top = null;
    }

    /**
     * 入栈
     *
     * @param data 入栈的数据
     */
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈
     *
     * @return 出栈的数据
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空，无法出栈");
            return -1; // 表示栈为空或者栈中无法存储-1的元素，具体可根据实际需求修改
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    /**
     * 判断栈是否为空
     *
     * @return 栈为空返回true，否则返回false
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素的值
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("栈为空，无法获取栈顶元素");
            return -1; // 表示栈为空或者栈中无法存储-1的元素，具体可根据实际需求修改
        }
        return top.data;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("栈顶元素：" + stack.peek());

        System.out.println("出栈：" + stack.pop());
        System.out.println("出栈：" + stack.pop());

        System.out.println("栈是否为空：" + stack.isEmpty());
    }
}

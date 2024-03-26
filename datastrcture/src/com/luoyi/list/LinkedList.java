package com.luoyi.list;

/**
 * @Description 链表的实现
 * @Author Luoyi
 * @Date 2024/2/19
 *
 * 需要一个指针temp cur
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head; // 头节点

    public LinkedList() {
        this.head = null;
    }

    /**
     * 在链表末尾添加节点
     *
     * @param data 要添加的数据
     */
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * 在链表头部插入节点
     *
     * @param data 要插入的数据
     */
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 删除指定值的节点
     *
     * @param data 要删除的数据
     */
    public void delete(int data) {
        if (head == null) {
            System.out.println("链表为空，无法删除节点");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("未找到指定值的节点");
        }
    }

    /**
     * 打印链表元素
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        System.out.print("链表元素：");
        linkedList.printList();

        linkedList.prepend(0);

        System.out.print("链表元素（头部插入后）：");
        linkedList.printList();

        linkedList.delete(2);

        System.out.print("链表元素（删除值为2的节点后）：");
        linkedList.printList();
    }
}

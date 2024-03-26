package com.luoyi.list;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/20
 * <p>
 * <p>
 * 双向链表的实现
 */
public class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node pre;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }

        private Node head; // 头节点

        public DoublyLinkedList() {
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
                newNode.pre = current;  //ToDo   双向绑定

            }
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

            Node current = head;
//            while (current.next != null && current.next.data != data) {  // ToDo 可以找下一个节点也可以找当前节点
//                current = current.next;
//            }
//
//            if (current.next != null && current.pre != null && current.pre.pre != null) { //todo 一定要进行判断
//                current.next = current.next.next;
//                current.pre.pre.pre = current.pre;
//            } else {
//                System.out.println("未找到指定值的节点");
//            }

            while (current!= null && current.data != data) {  // ToDo 可以找下一个节点也可以找当前节点
                current = current.next;
            }

            if ( current.next!= null) { //todo 一定要进行判断,否者会报空指针异常
                current.pre.next = current.next;
                current.next.pre = current.pre;
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
            DoublyLinkedList linkedList = new DoublyLinkedList();

            linkedList.append(1);
            linkedList.append(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);
            linkedList.append(6);

            System.out.print("链表元素：");
            linkedList.printList();


            System.out.print("链表元素（头部插入后）：");
            linkedList.printList();

            linkedList.delete(4);

            System.out.print("链表元素（删除值为4的节点后）：");
            linkedList.printList();

            linkedList.delete(5);

            System.out.print("链表元素（删除值为5的节点后）：");
            linkedList.printList();

            linkedList.delete(6);

            System.out.print("链表元素（删除值为6的节点后）：");
            linkedList.printList();
        }
    }


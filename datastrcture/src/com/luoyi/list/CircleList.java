package com.luoyi.list;

/**
 * @Description Speak less, type more code
 * @Author Luoyi
 * @Date 2024/2/20
 * 循环链表
 *
 * 其实和一般的链表很像，只不过判断标准变成了！=head,以及头结点为空注意指向自己
 */
public class CircleList {

    // 定义一个静态内部类，避免已有Node类，而无法建立
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int length;

    public CircleList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * 增加节点到循环链表
     *
     * @param data 数据
     */
    public void append(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            head.next = head; // 自己指向自己形成循环
        } else {
            Node cur = head;
            while (cur.next != head) {
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.next = head; // 新节点指向头结点形成循环
        }
        length++;
    }

    /**
     * 打印循环链表
     */
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
        } else {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircleList circleList = new CircleList();

        circleList.append(1);
        circleList.append(2);
        circleList.append(3);

        circleList.display();
    }
}

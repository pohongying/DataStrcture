package com.luoyi.list;

/**
 * @Description 静态链表
 * @Author Luoyi
 * @Date 2024/2/19
 *
 * 注：1. 索引为0的节点不存放数据，cur指向第一个空闲节点的下标
 *    2.  最后一个元素（即下标Maxsize-1）的cur指向第一个有效数据的下标，初始化为0
 */
class StaticNode {
    Object data;
    int cur;

    public StaticNode(Object data, int cur) {
        this.data = data;
        this.cur = cur;
    }
}

public class StaticList {
    StaticNode[] space;
    public static final int MAX_SIZE = 10;
    int currentFree;  // 目前空闲节点
    int length;       // 表的长度

    public StaticList() {
        space = new StaticNode[MAX_SIZE];
        currentFree = 1;
        length = 0;

        // 初始化链表中的各个节点
        for (int i = 0; i < space.length - 1; i++) {
            space[i] = new StaticNode(null, i + 1);
        }
        space[MAX_SIZE - 1] = new StaticNode(null, 0);
    }

    /**
     * 获取空闲节点的下标
     */
    public int Malloc_SLL() {
        int i = space[0].cur;
        if (i != 0) {
            space[0].cur = space[i].cur;    // 这一段代码非常关键！！
            // 确保i=0的cur始终指向空闲节点
        }
        return i;
    }

    /**
     * 增加节点
     */
    public void add(Object data, int i) {
        if (i < 1 || i > MAX_SIZE - 1) {
            System.out.println("插入的值不在范围之内");
            return;
        }
        currentFree = Malloc_SLL();
        int j = MAX_SIZE - 1;
        int k;
        for (k = 1; k < i; k++) {    // TODO: 2024/2/20   必须确保索引为1的位置已经被插入了
            j = space[j].cur;        // j 始终为被插入元素的上一个索引
        }
        space[currentFree].data = data;
        space[currentFree].cur = space[j].cur;  // 确保插入元素的cur指向上一个索引的cur，也就是0
        space[j].cur = currentFree;  // TODO: 2024/2/20 确保最后一个元素的指针指向第一个有效数据，确保能够遍历


    }

    /**
     * 打印链表元素
     */
    public void displayList() {
        System.out.print("链表元素: ");
        for (int currentIndex = space[MAX_SIZE - 1].cur; currentIndex != 0; currentIndex = space[currentIndex].cur) {
            System.out.print(space[currentIndex].data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StaticList staticList = new StaticList();

        // 添加节点
        staticList.add(10,1);
        staticList.add(20,2);
        staticList.add(30,3);

        // 打印链表元素
        staticList.displayList();
    }
}

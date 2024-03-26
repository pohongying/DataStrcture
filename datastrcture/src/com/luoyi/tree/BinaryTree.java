package com.luoyi.tree;

/**
 * @Description Speak less ,type more code
 * @Author Luoyi
 * @Date 2024/2/21
 * <p>
 * 二叉树
 */
public class BinaryTree {

    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }


    // 前序遍历 ,递归

    public void preOrder() {

        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");

        }
    }

    // 中序遍历
    public void infixOrder() {

        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");

        }

    }


    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");

        }
    }

    // 前序查找
    public void preOrderSearch(int no) {
        if (root != null) {
            HeroNode hn = root.preOrderSearch(no);
            System.out.println(hn);
        } else {
            System.out.println("根节点为空");
        }
    }


    // 中序查找
    public void infixOrderSearch(int no) {
        if (root != null) {
            HeroNode hn = root.infixOrderSearch(no);
            System.out.println(hn);
        } else {
            System.out.println("根节点为空");
        }
    }


    // 后序查找
    public void postOrderSearch(int no) {
        if (root != null) {
            HeroNode hn = root.postOrderSearch(no);
            System.out.println(hn);
        } else {
            System.out.println("根节点为空");
        }
    }

    // 删除
    public  void delNode(int no){
        if (root != null){
            root.delNode(no);
        }else {
            System.out.println("根节点为空，不用删除");
        }
    }


}


class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode() {
    }

    public HeroNode(int no, String name, HeroNode left, HeroNode right) {
        this.no = no;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    /**
     * 获取
     *
     * @return no
     */
    public int getNo() {
        return no;
    }

    /**
     * 设置
     *
     * @param no
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return left
     */
    public HeroNode getLeft() {
        return left;
    }

    /**
     * 设置
     *
     * @param left
     */
    public void setLeft(HeroNode left) {
        this.left = left;
    }

    /**
     * 获取
     *
     * @return right
     */
    public HeroNode getRight() {
        return right;
    }

    /**
     * 设置
     *
     * @param right
     */
    public void setRight(HeroNode right) {
        this.right = right;
    }

    public String toString() {
        return "HeroNode{no = " + no + ", name = " + name;
    }


    // 前序遍历 ,递归

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找  递推
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序查找：");
        if (this.no == no) {
            System.out.println("已经找到");
            return this;
        }


        HeroNode newNode = null;
        if (this.left != null) {
            newNode = this.left.preOrderSearch(no);   //todo 如果找到则返回这个节点
        }
        if (newNode != null) {
            return newNode;
        }
        if (this.right != null) {
            newNode = this.right.preOrderSearch(no);
        }
        return newNode;
    }

    // 中序查找  递推
    public HeroNode infixOrderSearch(int no) {

        HeroNode newNode = null;
        if (this.left != null) {
            newNode = this.left.infixOrderSearch(no);
        }
        if (newNode != null) {
            return newNode;
        }
        System.out.println("进入中序查找：");
        if (this.no == no) {
            System.out.println("已经找到");
            return this;
        }
        if (this.right != null) {
            newNode = this.right.infixOrderSearch(no);
        }
        return newNode;
    }


    // 后序查找  递推
    public HeroNode postOrderSearch(int no) {
        HeroNode newNode = null;
        if (this.left != null) {
            newNode = this.left.postOrderSearch(no);
        }
        if (newNode != null) {
            return newNode;
        }

        if (this.right != null) {
            newNode = this.right.postOrderSearch(no);
        }
        if (newNode != null) {
            return newNode;

        }
        System.out.println("进入后序查找：");
        if (this.no == no) {
            System.out.println("已经找到");
            return this;
        }
        return newNode;
    }


    // 删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            // 左子节点为要删除的节点
            if (this.left.left == null && this.left.right == null) {
                // 如果要删除的节点是叶子节点，直接删除
                this.left = null;
            } else if (this.left.left != null && this.left.right == null) {
                // 如果只有左子节点，则让左子节点替代当前节点
                this.left = this.left.left;
            } else if (this.left.left == null && this.left.right != null) {
                // 如果只有右子节点，则让右子节点替代当前节点
                this.left = this.left.right;
            } else {
                // 如果左右子节点都存在，则交换左右子节点的位置
                HeroNode temp = this.left.left;
                this.left.left = this.left.right;
                this.left.right = temp;
            }
        } else if (this.right != null && this.right.no == no) {
            // 右子节点为要删除的节点，同样的逻辑处理右子树
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
            } else if (this.right.left != null && this.right.right == null) {
                // 如果只有左子节点，则让左子节点替代当前节点
                this.right = this.right.left;
            } else if (this.right.left == null && this.right.right != null) {
                // 如果只有右子节点，则让右子节点替代当前节点
                this.right = this.right.right;
            } else {
                // 如果左右子节点都存在，则交换左右子节点的位置
                HeroNode temp = this.right.left;
                this.right.left = this.right.right;
                this.right.right = temp;
            }
        } else {
            // 递归处理左右子树
            if (this.left != null) {
                this.left.delNode(no);
            }
            if (this.right != null) {
                this.right.delNode(no);
            }
        }
    }

}


class BinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode hn1 = new HeroNode(1, "张三", null, null);
        HeroNode hn2 = new HeroNode(2, "李四", null, null);
        HeroNode hn3 = new HeroNode(3, "王五", null, null);
        HeroNode hn4 = new HeroNode(4, "赵六", null, null);
        HeroNode hn5 = new HeroNode(5, "罗七", null, null);
        HeroNode hn6 = new HeroNode(6, "习八", null, null);
        HeroNode hn7 = new HeroNode(7, "刘久", null, null);
        HeroNode hn8 = new HeroNode(8, "孙十", null, null);

        hn1.setLeft(hn2);
        hn1.setRight(hn3);
        hn3.setLeft(hn4);
        hn3.setRight(hn5);
        hn5.setLeft(hn6);
        hn5.setRight(hn7);
        hn7.setRight(hn8);


        BinaryTree bt = new BinaryTree(hn1);
        System.out.println("前序遍历：");
        bt.preOrder();
        System.out.println("中序遍历________");
        bt.infixOrder();

        System.out.println("后序遍历-------");
        bt.postOrder();

        System.out.println("————————————");
        bt.preOrderSearch(5);
        System.out.println("————————————");

        bt.infixOrderSearch(5);
        System.out.println("————————————");

        bt.postOrderSearch(2);

//        System.out.println("删除节点为4的：");
//        bt.delNode(4);
//        bt.preOrder();
//        System.out.println("========");
//        bt.delNode(5);
//        bt.preOrder();

        System.out.println("========");
        bt.delNode(7);
        bt.preOrder();
    }
}
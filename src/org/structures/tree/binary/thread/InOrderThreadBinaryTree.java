package org.structures.tree.binary.thread;

/**
 * 中序线索二叉树
 * @param <T>
 */
public class InOrderThreadBinaryTree<T> {

    /**
     * 线索二叉树的根结点
     */
    private final ThreadNode<T> root;

    /**
     * front指向p在中根次序下的前驱结点
     */
    private ThreadNode<T> front = null;

    private int i = 0;

    /**
     * 简单构造器
     */
    public InOrderThreadBinaryTree(){
        this.root = null;
    }

    /**
     * 可传入序列的构造器
     * 以标明空子树的先根序列构造中序线索二叉树
     * @param preList 传入的构造序列
     */
    public InOrderThreadBinaryTree(T[] preList) {
        // 以标明空子树的先根遍历序列构造二叉树，方法省略
        this.root = create(preList);
        // 二叉树中序线索化
        inOrderThread(this.root);
    }

    /**
     * 以标明空子树的先根遍历序列构造以preList[i]为根的子树
     * @param preList 传入的构造序列
     * @return 根结点
     */
    private ThreadNode<T> create(T[] preList) {
        ThreadNode<T> p = null;
        if (i < preList.length) {
            T element = preList[i++];
            if (element != null) {
                p = new ThreadNode<>(element);
                p.left = create(preList);
                p.right = create(preList);
            }
        }
        return p;
    }

    /**
     * 先根次序遍历中序线索二叉树<br/>
     * 非递归算法
     */
    public void preOrder() {
        System.out.print("先根次序遍历中序线索二叉树：  ");
        // 返回p在先根次序下的后继结点
        for (ThreadNode<T> p = this.root; p != null; p = preNext(p)) {
            System.out.print(p.data.toString() + " ");
        }
        System.out.println();
    }

    /**
     * 中根次序遍历中序线索二叉树<br/>
     * 非递归算法
     */
    public void inOrder() {
        System.out.print("中根次序遍历中序线索二叉树：  ");
        ThreadNode<T> p = this.root;
        // 寻找根的最左边的后代结点，即第一个访问结点
        while (p != null && !p.leftTag) {
            p = p.left;
        }
        while (p != null) {
            System.out.print(p.data.toString() + " ");
            // 返回p在中根次序下的后继结点
            p = this.inNext(p);
        }
        System.out.println();
    }

    /**
     * 中根次序反序遍历中序线索二叉树<br/>
     * 非递归算法
     */
    public void inOrderPrevious() {
        System.out.print("中根次序（反序）遍历中序线索二叉树：  ");
        ThreadNode<T> p = this.root;
        // 寻找根的最右边的后代结点
        while (p != null && !p.rightTag) {
            p = p.right;
        }
        while (p != null) {
            System.out.print(p.data.toString() + " ");
            // 返回p在中根次序下的前驱结点
            p = inPrev(p);
        }
        System.out.println();
    }

    /**
     * 后根次序反序遍历中序线索二叉树<br/>
     * 非递归算法
     */
    public void postOrderPrevious() {
        System.out.print("后根次序（反序）遍历中序线索二叉树：  ");
        // 返回p在后根次序下的前驱结点
        for (ThreadNode<T> p = this.root; p != null; p = postPrev(p)) {
            System.out.print(p.data.toString() + " ");
        }
        System.out.println();
    }

    /**
     * 判断是否空二叉树
     * @return 是否空二叉树
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * 中序线索化以p结点为根的子树
     * @param p 当前子树的根结点
     */
    private void inOrderThread(ThreadNode<T> p) {
        if (p != null) {
            // 中序线索化p的左子树
            inOrderThread(p.left);
            // 若p的左子树为空
            if (p.left == null) {
                // 设置左线索标记
                p.leftTag = true;
                // 设置p.left为指向前驱front的线索
                p.left = front;
            }
            // 若p的右子树为空
            if (p.right == null) {
                // 设置右线索标记
                p.rightTag = true;
            }
            if (front != null && front.rightTag) {
                // 设置前驱front，right为指向后继p的线索
                front.right = p;
            }
            // front记得当前p，即是p下一个访问结点的前驱
            front = p;
            // 中序线索化p的右子树
            inOrderThread(p.right);
        }
    }

    /**
     * 返回p在先根次序下的后继结点
     * @param p 待查找的结点
     * @return p在先根次序下的后继结点
     */
    private ThreadNode<T> preNext(ThreadNode<T> p) {
        // 若p有左孩子，则p的左孩子是p的后继
        if (!p.leftTag) {
            return p.left;
        }
        // 否则，p后继是p最远中序祖先的右孩子
        while (p.rightTag && p.right != null) {
            // 沿着右线索向上，寻找到最远中序祖先
            p = p.right;
        }
        // 祖先的右孩子是后继
        return p.right;
    }

    /**
     * 返回p在中根次序下的后继结点
     * @param p 待查找的结点
     * @return p在中根次序下的后继结点
     */
    private ThreadNode<T> inNext(ThreadNode<T> p) {
        // 右线索标记，则p.right指向p的后继结点
        if (p.rightTag) {
            return p.right;
        }
        // 进入p的右子树
        p = p.right;
        // 找到最左边的后代结点
        while (!p.leftTag) {
            p = p.left;
        }
        return p;
    }

    /**
     * 返回p在中根次序下的前驱结点
     * @param p 待查找的结点
     * @return p在中根次序下的前驱结点
     */
    private ThreadNode<T> inPrev(ThreadNode<T> p) {
        // 左线索标记，则p.left指向p的前驱结点
        if (p.leftTag) {
            return p.left;
        }
        // 进入p的左子树
        p = p.left;
        // 找到最右边的子孙结点
        while (!p.rightTag) {
            p = p.right;
        }
        return p;
    }

    /**
     * 返回p在后根次序下的前驱结点
     * @param p 待查找的结点
     * @return p在后根次序下的前驱结点
     */
    private ThreadNode<T> postPrev(ThreadNode<T> p) {
        // 若p有右孩子，则p的右孩子是p的前驱结点
        if(!p.rightTag) {
            return p.right;
        }
        // 否则，p的前驱是左兄弟或其最远中序祖先的左孩子
        while (p.leftTag && p.left != null) {
            // 寻找最远中序祖先
            p = p.left;
        }
        // 祖先的左孩子是前驱
        return p.left;
    }

}

package org.structures.tree.binary.thread;

public class ThreadNode<T> {

    T data;

    // 左孩子or前驱结点
    ThreadNode<T> left;

    // 左线索标记，true表示线索，false表示孩子
    boolean leftTag;

    // 右孩子or后继结点
    ThreadNode<T> right;

    // 右线索标记，true表示线索，false表示孩子
    boolean rightTag;

    public ThreadNode() {}

    public ThreadNode(T data) {
        this(data, null, false, null, false);
    }

    public ThreadNode(T data, ThreadNode<T> left, boolean leftTag, ThreadNode<T> right, boolean rightTag) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.leftTag = leftTag;
        this.rightTag = rightTag;
    }

    /**
     * 返回结点数据域的描述字符串
     * @return
     */
    @Override
    public String toString() {
        return this.data.toString();
    }

    /**
     * 判断是否叶子结点
     * @return
     */
    public boolean isLeaf() {
        return !this.leftTag && !this.rightTag;
    }

}

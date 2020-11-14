package org.structures.tree.avl;

public interface IAvlTree<T extends Comparable<? super T>> {
    
    /**
     * 判断是否是空二叉树
     * @return
     */
    boolean isEmpty();
    
    /**
     * 返回二叉树结点个数
     * @return
     */
    int size();
    
    /**
     * 返回二叉树高度
     * @return
     */
    int height();
    
    /**
     * 输出前序遍历序列
     */
    void preOrder();
    
    /**
     * 输出中序遍历序列
     */
    void inOrder();
    
    /**
     * 输出后序遍历序列
     */
    void postOrder();
    
    /**
     * 输出层序遍历序列
     */
    void levelOrder();
    
    /**
     * 插入x元素作为根结点并返回
     * @param x
     * @return
     */
    AvlNode<T> insert(T x);
    
    /**
     * 插入x作为p的左右孩子
     * @param parent
     * @param x
     * @param leftChild
     * @return
     */
    AvlNode<T> insert(AvlNode<T> parent, T x, boolean leftChild);
    
    /**
     * 插入parent结点的左或右子树
     * @param parent
     * @param leftChild
     */
    void remove(AvlNode<T> parent, boolean leftChild);
    
    /**
     * 删除二叉树所有结点
     */
    void clear();
    
    /**
     * 查找并返回关键字为key的结点
     * @param key
     * @return
     */
    AvlNode<T> search(T key);
    
    /**
     * 判断是否包含关键字为key的元素
     * @param key
     * @return
     */
    boolean contains(T key);
    
    /**
     * 返回关键字为key结点所在层次
     * @param key
     * @return
     */
    int level(T key);

}

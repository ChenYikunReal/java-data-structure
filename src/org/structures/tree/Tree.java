package org.structures.tree;

import org.structures.tree.node.TreeNode;

/**
 * 朴素的树的ADT定义
 * @param <T>
 */
public interface Tree<T> {

    boolean isEmpty();

    int level(T key);

    int size();

    int height();

    void preOrder();

    void inOrder();

    void postOrder();

    void levelOrder();

    TreeNode<T> insertRoot(T x);

    TreeNode<T> insertChild(TreeNode<T> node, T x, int i);

    void remove(TreeNode<T> node, int i);

    void clear();

    TreeNode<T> search(T key);

    boolean contains(T key);

    T remove(T key);

}

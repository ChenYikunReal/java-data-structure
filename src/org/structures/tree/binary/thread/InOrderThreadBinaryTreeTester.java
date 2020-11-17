package org.structures.tree.binary.thread;

public class InOrderThreadBinaryTreeTester {

    public static void main(String[] args) {
        // 用于构造中序线索二叉树的先根序列
        String[] preList = {"A", "B", "D", null, null, "E", "G", null, null, null, "C", "F", null, "H", null, null, "K"};
        // 创建中序线索二叉树
        InOrderThreadBinaryTree<String> tree = new InOrderThreadBinaryTree<>(preList);
        // 先根次序遍历
        tree.preOrder();
        // 中根次序遍历
        tree.inOrder();
        // 中根次序遍历（求前驱）
        tree.inOrderPrevious();
        // 后根次序遍历（求前驱）
        tree.postOrderPrevious();
    }

}

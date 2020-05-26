package org.structures.tree;

public class BinaryTreeTester {
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setRight(node6);
        BinaryTree<Integer> tree = new BinaryTree<>(node1);
//        tree.preOrder();
//        tree.iteratorPreOrder();
//        tree.inOrder();
//        tree.iteratorInOrder();
//        tree.postOrder();
//        tree.iteratorPostOrder();
//        tree.levelOrder();
//        System.out.println(tree.size());
//        System.out.println(tree.height());
//        System.out.println(tree.search(4) + " ");
//        System.out.println(tree.level(4));
//        System.out.println(tree.contains(4));
//        System.out.println(tree.search(7) + " ");
//        System.out.println(tree.level(7));
//        System.out.println(tree.contains(7));
//        tree.insert(7);
//        tree.levelOrder();
//        System.out.println(tree.search(7) + " ");
//        System.out.println(tree.level(7));
//        System.out.println(tree.contains(7));
//        System.out.println(tree.search(4) + " ");
//        System.out.println(tree.level(4));
//        System.out.println(tree.contains(4));
        System.out.println(tree.minSizeBetweenTwoNodes(node1, node2));
    }

}

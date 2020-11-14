package org.structures.tree.huffman;

public class HuffmanTreeTester {

    public static void main(String[] args) {
        //1, 3, 5, 6, 2, 22, 77, 4, 9
        int[] leaves = {2, 4, 5, 3};
        HuffmanTree tree = new HuffmanTree(leaves);
        HuffmanNode[] nodeList = tree.huffmanTree;
        for (HuffmanNode node : nodeList) {
            System.out.println(node);
        }
    }

}

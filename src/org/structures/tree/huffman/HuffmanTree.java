package org.structures.tree.huffman;

import org.structures.tree.TreeException;

public class HuffmanTree {
    
    protected HuffmanNode[] huffmanTree;
    
    public HuffmanTree(int[] leafs) {
        //异常条件判断
        if (leafs.length <= 1) {
            throw new TreeException("叶子结点个数小于2，无法构建哈夫曼树");
        }
        //初始化储存空间
        huffmanTree = new HuffmanNode[leafs.length*2-1];
        //构造n棵只含根结点的二叉树
        for (int i = 0; i < leafs.length; i++) {
            HuffmanNode node = new HuffmanNode(leafs[i]);
            huffmanTree[i] = node;
        }
        //构造哈夫曼树的选取与合并
        for (int i = leafs.length; i < huffmanTree.length; i++) {
            //获取权值最小的结点下标
            int miniNum_1 = selectMiniNum1();
            //获取权值次小的结点下标
            int miniNum_2 = selectMiniNum2();
            if (miniNum_1 == -1 || miniNum_2 == -1) {
                return;
            }
            //两个权值最小的结点合并为新节点
            HuffmanNode node = new HuffmanNode(huffmanTree[miniNum_1].getWeight() + 
                    huffmanTree[miniNum_2].getWeight(), miniNum_1, miniNum_2);
            huffmanTree[i] = node;
            huffmanTree[miniNum_1].setParent(i);
            huffmanTree[miniNum_2].setParent(i);
        }
    }
    
    /**
     * 获取权值最小的结点下标
     * @return
     */
    private int selectMiniNum1() {
        //最小值
        int min = -1;
        //最小值下标
        int index = -1;
        //是否完成最小值初始化
        boolean flag = false;
        //遍历一遍
        for (int i = 0; i < huffmanTree.length; i++) {
            //排空、只看根结点，否则跳过
            if (huffmanTree[i] == null || huffmanTree[i].getParent() != -1) {
                continue;
            } else if (!flag) {     //没初始化先初始化然后跳过
                //初始化
                min = huffmanTree[i].getWeight();
                index = i;
                //以后不再初始化min
                flag = true;
                //跳过本次循环
                continue;
            }
            int tempWeight = huffmanTree[i].getWeight();
            //低效比较
            if (tempWeight < min) {
                min = tempWeight;
                index = i;
            }
        }
        return index;
    }
    
    /**
     * 获取权值次小的结点下标
     * @return
     */
    private int selectMiniNum2() {
        //次小值
        int min = -1;
        //是否完成次小值初始化
        boolean flag = false;
        //最小值下标（调用上面的方法）
        int index = selectMiniNum1();
        //最小值都不存在，则次小值也不存在
        if (index == -1) {
            return -1;
        }
        //次小值下标
        int index2 = -1;
        //遍历一遍
        for (int i = 0; i < huffmanTree.length; i++) {
            //最小值不要、排空、只看根结点，否则跳过
            if (index == i || huffmanTree[i] == null || huffmanTree[i].getParent() != -1) {
                continue;
            } else if (!flag) {     //没初始化先初始化然后跳过
                //初始化
                min = huffmanTree[i].getWeight();
                index2 = i;
                //以后不再初始化min
                flag = true;
                //跳过本次循环
                continue;
            }
            int tempWeight = huffmanTree[i].getWeight();
            //低效比较
            if (tempWeight < min) {
                min = tempWeight;
                index2 = i;
            }
        }
        return index2;
    }

}

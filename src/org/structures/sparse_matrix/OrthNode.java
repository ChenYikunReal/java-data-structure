package org.structures.sparse_matrix;

/**
 * 矩阵的十字链表存储
 * 这是十字链表的结点
 */
public class OrthNode {
    
    private Element data;
    
    private OrthNode right;
    
    private OrthNode down;

    public OrthNode(Element data, OrthNode right, OrthNode down) {
        super();
        this.data = data;
        this.right = right;
        this.down = down;
    }

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public OrthNode getRight() {
        return right;
    }

    public void setRight(OrthNode right) {
        this.right = right;
    }

    public OrthNode getDown() {
        return down;
    }

    public void setDown(OrthNode down) {
        this.down = down;
    }

}

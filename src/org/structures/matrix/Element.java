package org.structures.matrix;

public class Element {
    
    /**
     * 行
     */
    private int row;
    
    /**
     * 列
     */
    private int column;
    
    /**
     * 非0元素值item
     */
    private int item;

    public Element(int row, int column, int item) {
        super();
        this.row = row;
        this.column = column;
        this.item = item;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

}

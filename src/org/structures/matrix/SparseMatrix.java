package org.structures.matrix;

/**
 * 三元组顺序表实现稀疏矩阵存储
 */
public class SparseMatrix {
    
    /**
     * 数组容量
     */
    private final static int MAX_TERM = 100;
    
    /**
     * 维护一个数组储存矩阵
     */
    private Element[] list;
    
    /**
     * 矩阵行数
     */
    private int rowNum;
    
    /**
     * 矩阵列数
     */
    private int columnNum;
    
    /**
     * 非0元素个数
     */
    private int elementNum;
    
    public SparseMatrix() {
        super();
        this.list = new Element[MAX_TERM];
    }

    public SparseMatrix(int rowNum, int columnNum, int elementNum) {
        this();
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.elementNum = elementNum;
    }
    
    public SparseMatrix(int arraySize, int rowNum, int columnNum, int elementNum) {
        super();
        this.list = new Element[arraySize];
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.elementNum = elementNum;
    }

    public SparseMatrix(Element[] list, int rowNum, int columnNum, int elementNum) {
        super();
        this.list = list;
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.elementNum = elementNum;
    }

    /**
     * 转置算法1
     * 直接取，顺序存
     * O(columnNum × elementNum)
     * 当 elementNum > rowNNum时，性能较差
     * @return
     */
    public SparseMatrix trans1() {
        SparseMatrix result = new SparseMatrix();
        Element[] resultList = new Element[MAX_TERM];
        int pb = 0;
        result.setColumnNum(this.rowNum);
        result.setRowNum(this.columnNum);
        result.setElementNum(this.elementNum);
        //依次考察当前矩阵的每一列
        for (int col = 1; col <= this.columnNum; col++) {
            //扫描当前的三元组顺序表
            for (int pa = 0; pa < this.elementNum; pa++) {
                //处理col列元素
                if (list[pa].getColumn() == col) {
                    Element element = new Element(list[pa].getColumn(), list[pa].getRow(), list[pa].getItem());
                    resultList[pb] = element;
                    pb++;
                }
            }
        }
        result.setList(resultList);
        return result;
    }
    
    /**
     * 转置算法2
     * 顺序取，直接存
     * O(columnNum + elementNum)
     * 空间上多了两个数组
     * @return
     */
    public SparseMatrix trans2() {
        //转制后的矩阵
        SparseMatrix result = new SparseMatrix();
        Element[] resultList = new Element[MAX_TERM];
        //当前列号
        int col;
        //转置矩阵的下标
        int index;
        //原矩阵中某列非零元素的个数，列数与数组编号差1
        int[] num = new int[columnNum];
        //原矩阵中某非零元素在转置矩阵中的位置
        int[] cpot = new int[columnNum];
        result.setColumnNum(this.rowNum);
        result.setRowNum(this.columnNum);
        result.setElementNum(this.elementNum);
        //初始化当前矩阵每一列非零元素的个数
        for (int i = 0; i < this.columnNum; i++) {
            num[i] = 0;
        }
        //求当前矩阵中每一列非零元素的个数
        for (int i = 0; i < this.elementNum; i++) {
            //取三元组的列号
            col = this.list[i].getColumn();
            num[col-1]++;
        }
        cpot[0] = 0;
        for (int i = 2; i <= this.elementNum; i++) {
            cpot[i-1] = cpot[i-2] + num[i-2];
        }
        //扫描当前矩阵三元组表
        for (int i = 0; i < this.elementNum; i++) {
            //取当前三元组的列号
            col = this.list[i].getColumn();
            //当前三元组在转置矩阵中的下标
            index = cpot[col-1];
            resultList[index] = new Element(this.list[i].getColumn(), 
                    this.list[i].getRow(), this.list[i].getItem());
            //预置同一列下一个三元组的下标
            cpot[col-1]++;
        }
        result.setList(resultList);
        return result;
    }

    public Element[] getList() {
        return list;
    }

    public void setList(Element[] list) {
        this.list = list;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getElementNum() {
        return elementNum;
    }

    public void setElementNum(int elementNum) {
        this.elementNum = elementNum;
    }

}

package org.structures.matrix;

public class Matrix {

    // 矩阵行数、列数
    protected int rows, columns;

    // 二维数组，存储矩阵元素
    protected int[][] element;

    // 构造m×n零矩阵。若m或n为负数，Java抛出负数组长度异常
    public Matrix(int m, int n) {
        // 数组元素初值为0
        this.element = new int[m][n];
        this.rows = m;
        this.columns = n;
    }

    // 构造n×n零方阵
    public Matrix(int n) {
        this(n,n);
    }

    // 构造m×n矩阵，由value[][]提供元素
    public Matrix(int m, int n, int[][] value) {
        this(m, n);
        // value元素不足时补0，忽略多余元素
        for (int i = 0; i < value.length && i < m; i++) {
            for (int j = 0; j < value[i].length && j < n; j++) {
                this.element[i][j] = value[i][j];
            }
        }
    }

    // 返回矩阵行数
    public int getRows() {
        return this.rows;
    }

    // 返回矩阵列数
    public int getColumns() {
        return this.columns;
    }

    // 返回矩阵第i行第j列元素。若i、j越界，抛出序号越界异常
    public int get(int i, int j) {
        if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) {
            return this.element[i][j];
        }
        throw new IndexOutOfBoundsException("i="+i+"，j="+j);
    }

    // 设置矩阵第i行第j列元素为x。若i、j越界，抛出序号越界异常
    public void set(int i, int j, int x) {
        if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) {
            this.element[i][j] = x;
        } else {
            throw new IndexOutOfBoundsException("i="+i+"，j="+j);
        }
    }

    // 返回矩阵所有元素的描述字符串，行主序遍历
    public String toString() {
        StringBuilder str= new StringBuilder(" 矩阵" + this.getClass().getName() + "（" + this.rows + "×" + this.columns + "）：\n");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                // "%6d"格式表示十进制整数占6列
                str.append(String.format("%6d", this.element[i][j]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    // 设置矩阵为m行n列。若参数指定行列数较大，则将矩阵扩容，并复制原矩阵元素。用于7.2.1节图的邻接矩阵存储结构
    public void setRowsColumns(int m, int n) {
        if (m > 0 && n > 0) {
            // 参数指定的行数或列数较大时，扩充二维数组容量
            if (m > this.element.length || n > this.element[0].length) {
                int[][] source = this.element;
                // 重新申请二维数组空间，元素初值为0
                this.element = new int[m*2][n*2];
                // 复制原二维数组元素
                for (int i = 0; i < this.rows; i++) {
                    for(int j = 0; j < this.columns; j++) {
                        this.element[i][j] = source[i][j];
                    }
                }
            }
            this.rows = m;
            this.columns = n;
        } else {
            throw new IllegalArgumentException("矩阵行列数不能≤0，m="+m+"，n="+n);
        }
    }
}

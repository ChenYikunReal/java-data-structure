package org.structures.list.polynomial;

public class PolyNode {
    
    /**
     * 定义结点系数域
     */
    private int coef;
    
    /**
     * 定义结点指数域
     */
    private int exp;
    
    /**
     * 定义结点后继引用域
     */
    private PolyNode next;
    
    /**
     * 无参数构造器
     * 构造空结点
     */
    public PolyNode() {
        this.next = null;
    }

    /**
     * 有参数构造器
     * 初始化系数、指数
     * @param coef
     * @param exp
     */
    public PolyNode(int coef, int exp) {
        super();
        this.coef = coef;
        this.exp = exp;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public PolyNode getNext() {
        return next;
    }

    public void setNext(PolyNode next) {
        this.next = next;
    }

}

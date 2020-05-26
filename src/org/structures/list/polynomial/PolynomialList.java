package org.structures.list.polynomial;

public class PolynomialList {
    
    /**
     * 头引用
     */
    protected PolyNode first;
    
    /**
     * 尾插法实现构造器
     * @param initialList
     */
    public PolynomialList(String[] initialList) {
        //头引用初始化为头结点
        first = new PolyNode();
        //初始化尾引用，实现未插入
        PolyNode rear = first;
        for (int i = 0; i < initialList.length; i++) {
            //以逗号分离系数、指数
            String[] polyInfo = initialList[i].split(",");
            int coef = Integer.parseInt(polyInfo[0]);
            int exp = Integer.parseInt(polyInfo[1]);
            //生成多项式结点
            PolyNode node = new PolyNode(coef, exp);
            rear.setNext(node);
            rear = node;
        }
    }
    
    public void printpolynomial() {
        PolyNode node = first;
        StringBuilder str = new StringBuilder();
        while (node != null) {
            if (node.getCoef() != 0) {
                str.append(node.getCoef() + "x^" + node.getExp());
                //System.out.print();
                if (node.getNext() != null) {
                    str.append(" + ");
                } else {
                    str.append(".");
                }
            }
            node = node.getNext();
        }
        System.out.println(str);
    }

}

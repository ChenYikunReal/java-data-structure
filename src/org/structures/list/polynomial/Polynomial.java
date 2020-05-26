package org.structures.list.polynomial;

public class Polynomial {
    
    public PolynomialList addPolynomial(String[] initialA, String[] initialB) {
        //初始化一元多项式A、B的单链表
        PolynomialList polyA = new PolynomialList(initialA);
        PolynomialList polyB = new PolynomialList(initialB);
        //初始化工作引用pre、p
        PolyNode pre = polyA.first, p = pre.getNext();
        //初始化工作引用q
        PolyNode q = polyB.first.getNext();
        PolyNode qTemp;
        while (p != null && q != null) {
            //第一种情况
            if (p.getExp() < q.getExp()) {
                pre = p;
                p = p.getNext();
            } else if (p.getExp() > q.getExp()) {   //第二种情况
                qTemp = q.getNext();
                pre.setNext(q);
                q.setNext(p);
                q = qTemp;
            } else {    //第三种情况
                //系数相加
                p.setCoef(p.getCoef() + q.getCoef());
                //系数为0
                if (p.getCoef() == 0) {
                    pre.setNext(p.getNext());
                    p = pre.getNext();
                } else {    //系数不为0
                    pre = p;
                    p = p.getNext();
                }
                q = q.getNext();
            }
        }
        if (q != null) {
            //将q连接到第一个链表之后
            pre.setNext(q);
        }
        return polyA;
    }

}

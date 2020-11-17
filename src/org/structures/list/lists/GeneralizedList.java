package org.structures.list.lists;

/**
 * 双链表示的广义表类
 * @param <T>
 */
public class GeneralizedList<T> {

    /**
     * 头指针，指向（引用）头结点
     */
    private GeneralizedNode<T> head;

    /**
     * 构造空广义表
     */
    public GeneralizedList() {
        // 创建头结点，3个域值均为null
        this.head = new GeneralizedNode<>();
    }

    /**
     * 构造广义表<br/>
     * 结点次序与数组元素次序相同，采用尾插入构造，算法同单链表
     * @param atoms 提供原子初值
     */
    public GeneralizedList(T[] atoms) {
        // 创建空广义表，只有头结点
        this();
        GeneralizedNode<T> rear=this.head;
        for (T atom : atoms) {
            // 尾插入
            rear.next = new GeneralizedNode<T>(atom);
            rear = rear.next;
        }
    }

    /**
     * 判断广义表是否空
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * @return 广义表所有元素的描述字符串
     */
    public String toString() {
        return this.toString("");
    }

    /**
     * 广义表递归遍历算法<br/>
     * 形式为“(,)”
     * @param str
     * @return 广义表所有元素值对应的字符串
     */
    public String toString(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        for (GeneralizedNode<T> p = this.head.next; p!=null; p=p.next) {
            if (p.child == null) {
                builder.append(p.data.toString());
            } else {
                // 递归调用，遍历子表添加子表描述字符串
                builder.append(p.child.toString());
            }
            if (p.next != null) {
                builder.append(",");
            }
        }
        // 空表返回()
        builder.append(')');
        return builder.toString();
    }

    /**
     * 获取广义表长度<br/>
     * 算法类似于单链表的size()
     * @return 广义表长度
     */
    public int size() {
        int i = 0;
        for (GeneralizedNode<T> p = this.head.next; p != null; p = p.next) {
            i++;
        }
        return i;
    }

    /**
     * 获取广义表深度<br/>
     * 递归方法
     * @return 广义表深度
     */
    public int depth() {
        int max = 1;
        for (GeneralizedNode<T> p = this.head.next; p != null; p = p.next)
            if (p.child != null) {
                // 递归调用，返回子表深度
                int d = p.child.depth();
                // 记住最大子表深度
                if (max <= d) {
                    // 当前广义表深度为子表深度加1
                    max = d + 1;
                }
            }
        return max;
    }

    /**
     * 插入原子x作为第i个元素<br/>
     * 算法同单链表
     * @param i
     * @param x
     * @return
     */
    public GeneralizedNode<T> insert(int i, T x) {
        if (x == null) {
            // 不能插入空对象，抛出空对象异常
            throw new NullPointerException("x==null");
        }
        // front指向头结点
        GeneralizedNode<T> front = this.head;
        //寻找第i-1个或最后一个结点（front指向）
        for (int j = 0;  front.next != null && j < i;  j++) {
            front = front.next;
        }
        // 在front之后插入值为x结点
        front.next = new GeneralizedNode<T>(x, null, front.next);
        // 返回插入结点
        return front.next;
    }

    /**
     * 在广义表最后添加原子结点<br/>
     * 算法同单链表
     * @param x
     * @return
     */
    public GeneralizedNode<T> insert(T x) {
        return insert(Integer.MAX_VALUE, x);
    }

    /**
     * 插入子表作为第i个元素<br/>
     * 算法同单链表插入结点
     * @param i
     * @param list
     * @return
     */
    public GeneralizedNode<T> insert(int i, GeneralizedList<T> list) {
        if (list == null) {
            // 不能插入空对象，抛出空对象异常
            throw new NullPointerException("x==null");
        }
        // front指向头结点
        GeneralizedNode<T> front = this.head;
        // 寻找第i-1个或最后一个结点（front指向）
        for (int j = 0;  front.next != null && j < i; j++) {
            front = front.next;
        }
        // 在front之后插入结点，无值，child指向list
        front.next = new GeneralizedNode<T>(null, list, front.next);
        // 返回插入结点
        return front.next;
    }

    /**
     * 在广义表最后添加子表
     * @param list
     * @return
     */
    public GeneralizedNode<T> insert(GeneralizedList<T> list) {
        return insert(Integer.MAX_VALUE, list);
    }

    /**
     * 删除第i个元素
     * @param i
     */
    public void remove(int i) {
        // TODO
    }

}

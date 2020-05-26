package org.structures.stack.both;

public class BothStackTester {

    public static void main(String[] args) {
        BothStack<String> stack = new BothStack<>();
        System.out.println("下面栈1、栈2交替入栈");
        stack.push(1, "a");
        stack.push(2, "b");
        stack.push(1, "c");
        stack.push(1, "d");
        stack.push(1, "e");
        stack.push(2, "f");
        System.out.println("下面栈1出栈");
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println("下面栈2出栈");
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(2));
    }

    //括号匹配算法
//    public int match(char[] bra_exp) {
//        //初始化栈
//        StackInterface<Character> stack = new SequentialStack<>(bra_exp.length);
//        //依次处理每一个字符
//        for (int i = 0; i < bra_exp.length; i++) {
//            //扫描当前字符是左括号
//            if (bra_exp[i] == ')') {
//                //判断栈是否非空
//                if (!stack.isEmpty()) {
//                    stack.pop();
//                } else {
//                    return -1;
//                }
//            } else if (bra_exp[i] == '(') {     //扫描当前字符是左括号
//                //入栈
//                stack.push('(');
//            }
//        }
//        //栈空则正确匹配
//        if (stack.isEmpty()) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }

}

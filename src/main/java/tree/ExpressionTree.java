package tree;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree {
    /**
     * 构造表达式树的静态方法。
     * 遍历表达式，若为操作数则构造单节点树压入stack，若为操作符，则弹出两个节点，与
     * 操作符构造成新的树，再压入stack中。最后stack中只剩一个节点，该节点就是我们要求的
     * 表达式树。
     * @param expressions 后缀表达式分解过后的字符串数组
     * @return
     */
    public static BinaryNode postfixToExpressionTree(String[] expressions){
        BinaryNode operand1;     //用于暂存弹出的BinaryNode节点
        BinaryNode operand2;
        Stack<BinaryNode> stack = new Stack<BinaryNode>(); //用于构造表达式树的栈
        for (String s:expressions) {   //遍历表达式
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                operand1=stack.pop();  //弹出操作数
                operand2=stack.pop();
                stack.push(new BinaryNode(s,operand2,operand1)); //构造成新树并压入栈中
            }else {
                stack.push(new BinaryNode(s));
            }

        }
        return stack.pop();
    }

    /**
     * 打印二叉树的方法。
     * 通过递归调用来打印二叉树。并在节点前缩进了与深度相当的空格，方便观察。
     * @param depth 当前节点在树中的的深度
     * @param binaryNode 当前树节点
     */
    public static void printBinaryTree(int depth,BinaryNode binaryNode){
        for (int i=0;i<depth;i++){  //打印与深度相当的缩进
            System.out.print("    ");
        }
        System.out.println(binaryNode.getElement());  //打印当前节点的数据
        if (binaryNode.getLeft() != null){  //若左子树不为空，那么递归调用打印方法，打印左子树
            printBinaryTree(depth+1,binaryNode.getLeft());
        }
        if (binaryNode.getRight() != null){  //若右子树不为空，那么递归调用打印方法，打印右子树
            printBinaryTree(depth+1,binaryNode.getRight());
        }

    }

    /**
     * 测试构造和打印表达式树的方法。
     * main()方法用于测试，负责接收表达式并将其拆解成字符串数组，传递给
     * postfixToExpressionTree方法，然后调用printBinaryTree方法打印返回的表达式树。
     * @param args 忽略
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();            //接收表达式
        String[] splits= s.split("");  //分解成字符串数组
        BinaryNode binaryNode=postfixToExpressionTree(splits);  //构造比表达式树
        printBinaryTree(0,binaryNode); //打印表达式树
    }





}


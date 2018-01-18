# Algorithm
学习数据结构和算法分析的一些实例，包括排序算法、搜索算法、递归、二叉树等等实例  
如二叉树中的表达式树构造的完整实例：  
## 表达式树
表达式树(expression tree)的树叶是操作数(operand)，如常量或变量名，而其他节点为操作符(operator)。如下图
![表达式树](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91.png)

<center>图1 (a+b\*c)+((d\*e+f)\*g)的表达式树</center>  

我们可以通过递归地产生一个带括号的左表达式，然后打印出在跟出的运算符，最后再递归地产生一个带括号的右表达式从而得到一个中缀表达式。这种一般的方法（左，节点，右）的方式成为**中序遍历**。
## 构造表达式树
我们现在给出一个算法来把后缀表达式转变成表达式树。  
设输入为:  
a b + c d e + * *   
前两个符号是操作数，因此创建两颗单节点书并将它们压入栈中。  

![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/1%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)

接着，+被读取，因此两棵树被弹出，一颗新的树形成，并被压入栈中。    

![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/2%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)


然后，c、d、e被读入，分别创建对应的单节点树，然后压入栈中。
![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/3%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)

接下来读到+号，因此两棵树合并。  
![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/4%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)

继续进行，读到\*号，弹出两棵树合成一颗新的树并压入栈中。  
![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/5%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)

最后，读入最后一个符号，两棵树合并，而最后的树被留在栈中。
![](http://odwpzo1jp.bkt.clouddn.com//starshipzhou/Algorithm/6%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%A0%91%E6%9E%84%E9%80%A0.png)
## 从后缀表达式构造表达式树的实现
创建节点类BinaryNode.class
```
    public class BinaryNode {
    String element;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(String element) {
        this.element = element;
    }

    public BinaryNode(String element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
    //为节省篇幅，getter()、setter()方法略去，请自行补充
}

```
常见一个ExpressionTree.class类，该类有三个静态方法，分别是：postfixToExpressionTree(String[] expressions)、printBinaryTree(int depth,BinaryNode binaryNode)和main(String[] args)。  
postfixToExpressionTree(String[] expressions)方法负责将后缀表达式构造成表达式树并返回：
```
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
```
printBinaryTree(int depth,BinaryNode binaryNode)方法负责打印二叉树，并在每个节点前锁紧与深度相当的空格，方便观察树的结构。
```
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
```
main()方法用于测试，负责接收表达式并将其拆解成字符串数组，传递给postfixToExpressionTree方法，然后调用printBinaryTree方法打印返回的表达式树。
```
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
```


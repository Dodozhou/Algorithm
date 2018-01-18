package binary_tree;

import org.omg.CORBA.Any;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType>{
        public BinaryNode(AnyType element) {
            this(element,null,null);
        }

         BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    /**
     * 通过一数组生成二叉树
     * @param nodes 要插入的数组
     * @return 插入完成的树
     */
    public BinaryNode<AnyType> getBinarySearchTree(AnyType[] nodes){
       BinaryNode<AnyType> t=new BinaryNode<AnyType>(nodes[0]);
       for (int i=1;i<nodes.length;i++){
           t=insert(t,nodes[i]);
       }
       return t;
    }

    /**
     * 二叉树的插入方法。
     * 传入一个树及要插入的值，递归遍历该树，并将其插在合适的位置。
     * @param t 树的根节点，若为null，则生成一个根节点，值为x
     * @param x 要插入的值
     * @return 新的二叉查找树
     */
    public BinaryNode<AnyType> insert(BinaryNode<AnyType> t,AnyType x){
        if (t==null){
            return new BinaryNode<AnyType>(x);
        }
        int result=x.compareTo(t.element);
        if (result<0){
            t.left=insert(t.left,x);
        }else
            t.right=insert(t.right,x);
        return t;
    }

    /**
     * 搜索方法。
     * 递归遍历二叉树，查找指定树t中是否有相应的值x
     * @param t 搜索的容器——二叉搜索树
     * @param x 搜索的目标值
     * @return true 或者 false
     */
    public boolean contains(BinaryNode<AnyType> t, AnyType x){
        if (t==null){
            return false;
        }
        int result=x.compareTo(t.element);
        if (result<0){
            return contains(t.left,x);
        }else if (result>0){
            return contains(t.right,x);
        }else {
            return true;
        }
    }

    /**
     * 创建数组并测试生成二叉搜索树的方法，最后调用printBinaryTree方法打印二叉树
     * @param args main命令参数
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
        Integer[] nums={3,1,2,4,6,5,9,7};
        BinaryNode<Integer> node = tree.getBinarySearchTree(nums);
        printBinaryTree(0,node);
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
        System.out.println(binaryNode.element);  //打印当前节点的数据
        if (binaryNode.left != null){  //若左子树不为空，那么递归调用打印方法，打印左子树
            printBinaryTree(depth+1,binaryNode.left);
        }
        if (binaryNode.right != null){  //若右子树不为空，那么递归调用打印方法，打印右子树
            printBinaryTree(depth+1,binaryNode.right);
        }

    }




}

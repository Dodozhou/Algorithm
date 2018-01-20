package binary_heap;

/**
 * 二叉堆。
 * @param <AnyType> 需要排序的数组的类型，必须要实现Comparable接口，例如Integer等
 */
public class BinaryHeap <AnyType extends Comparable<? super AnyType>>{
    private AnyType[] arr; //二叉堆所在的数组
    private int currentSize; //currentSize 当前堆中的元素数目，注意，不是arr的大小
    /**
     * 二叉堆的下滤操作方法。
     * 可以使得以该节点为根节点的子树变得有序。deleteMin和buildheap操作均依赖于该方法。
     * @param hole 空洞位置在数组中的索引（需要排序的子树的根节点）
     */
    private  void percolateDown(int hole){
        int child;
        AnyType tmp = arr[hole];  //暂存空洞节点的值

        for(; hole*2 <= currentSize; hole = child){ //对子树遍历进行
            child = hole*2;
            if (child != currentSize && arr[child+1].compareTo(arr[child])<0) //找出两个子节点中的较小者
                child++;
            if (arr[child].compareTo(tmp)<0)  //子节点较小者与空洞值相比
                arr[hole] = arr[child];
            else
                break;
        }
        arr[hole] = tmp;
    }

    /**
     * 二叉堆的构造方法，接收包含节点的数组，并完成二叉堆的构造
     * @param items 一个无序的，包含所有节点，大小等于节点数的数组
     */
    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        arr = (AnyType[]) new Comparable[(currentSize+2)*11/10];

        int i=1;
        for (AnyType item:items)
            arr[i++]=item;
        buildHeap();
    }

    /**
     * 构造堆的具体方法。
     */
    private void buildHeap() {
        for (int i = currentSize/2;i>0;i--){
            percolateDown(i);
        }
    }

    public AnyType[] getArr(){
        return arr;
    }
}

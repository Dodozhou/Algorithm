package algorithm.sorting;

/**
 * 堆排序的实现。
 * 堆排序具有目前所有排序算法的最佳的大O运行时间
 */
public class HeapSorting {
    /**
     * 获取当前节点的儿子节点的位置
     * @param i 当前节点位置
     * @return 左儿子节点位置
     */
    private static int leftChild(int i){
        return i*2+1;
    }

    /**
     * 用于deleteMax和buildHeap操作的方法
     * @param a 具有Comparable特征的数组
     * @param i 开始下滤的元素位置
     * @param n 二叉堆的实际元素个数
     * @param <AnyType> 二叉堆的元素类型
     */
    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a,int i,int n){
        AnyType tmp;
        int child;
        for (tmp = a[i];leftChild(i)<n;i = child){
            child=leftChild(i);
            if (child!=n-1 && a[child].compareTo(a[child+1])<0)
                child++;
            if (tmp.compareTo(a[child])<0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    /**
     * 堆排序算法的实现
     * @param a 待排序的堆数组
     * @param <AnyType> 数组类型，需继承Comparable
     * @return 排好序的数组
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType[] heapSort(AnyType[] a){
        for(int i = a.length/2-1;i>=0;i--)  /*建堆操作*/
            percDown(a,i,a.length);
        for (int i=a.length-1;i>0;i--){  /*交换以及deleteMax操作*/
             swapReferences(a,0,i);  //一次交换操作确定一个元素
            percDown(a,0,i);     //下滤使得最大值再次出现在新的二叉堆的根处
        }
        return a;
    }

    /**
     * 交换数组中两个位置的元素
     * @param a 数组
     * @param index1 位置1
     * @param index2 位置2
     * @param <AnyType> 数组类型
     */
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    public static void main(String[] args) {
        Integer[] items={9,5,7,4,3};
        Integer[] a=heapSort(items);
        for (int i:a){
            System.out.println(i);
        }
    }
}

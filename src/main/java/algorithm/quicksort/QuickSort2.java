package algorithm.quicksort;

public class QuickSort2 {

    private static final int CUTOFF = 3;
    /**
     * 快速排序的外部接口，供用户调用
     * @param a 需要排序的数组
     * @param <AnyType> 数组的类型
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a )
    {
        quicksort( a, 0, a.length - 1 );
    }

    /**
     * 3数中值分割法求枢纽值。
     * 将左、中、右3个位置上的数组进行排序，并将中值放到倒数第二位隐藏。
     * @param a 需要排序的数组
     * @param left 左起始位置
     * @param right 右终止位置
     * @param <AnyType> 数组类型
     * @return 枢纽值pivot
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a,int left, int right){
        int center = (left+right)/2;
        if (a[center].compareTo(a[left])<0)
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );
        //处理特殊情形
        if (center == right)
            return a[right];
        //将枢纽值放到倒数第二位
        swapReferences( a, center, right-1);
        return a[ right - 1 ];
    }

    /**
     * 实现递归调用的快速排序内部方法。
     * 使用3数中值分割法median3来获取枢纽值。
     * @param a 需要排序的数组
     * @param left 排序的左起始位置
     * @param right 排序的右终止位置
     * @param <AnyType> 数组类型
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right ){
        if( left + CUTOFF <= right ) {
            //获取枢纽值
            AnyType pivot = median3(a, left, right);
            int i = left, j = right - 1;
            for (; ; ) {
            /*
            从左右两边开始向中间遍历，注意++i和--j，它们是自增（减）操作，再进行比较，
            之所以这样，是因为median3方法中已经将左、中、右3个位置排过序了
             */
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            //最后一步，将枢纽值放回恰当的位置
            swapReferences(a, i, right - 1);   // Restore pivot

            //对左右子数组进行递归排序
            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        }
        else
            median3(a,left,right);
    }

    /**
     * 交换数组指定两个位置的值
     * @param a 执行交换的数组
     * @param index1 执行交换的位置1
     * @param index2 执行交换的位置2
     * @param <AnyType> 数组类型的泛型替代
     */
    public static <AnyType> void swapReferences(AnyType[] a,int index1, int index2){
        AnyType tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
}

package algorithm.sorting;

public class MergeSorting {
    /**
     * 负责递归调用的内部方法
     * @param a 一个Comparable类型的数组
     * @param tmpArray 存放归并结果的数组
     * @param left 子数组最左端的索引
     * @param right 子数组最右端的索引
     * @param <AnyType> 数组的类型
     */
    private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a,
                                                                                   AnyType[] tmpArray,
                                                                                    int left,
                                                                                    int right){
        if (left<right){
            int center=(left+right)/2;
            mergeSort(a,tmpArray,left,center);
            mergeSort(a,tmpArray,center+1,right);
            merge(a,tmpArray,left,center+1,right);
        }

    }

    /**
     * 将两个有序的数组合并的方法。
     * @param a 包含两个数组的数组（前半部分和后半部分各为一个数组）
     * @param tmpArray 用于存放结果的临时数组
     * @param leftPos 第一个数组的头
     * @param rightPos 第二个数组的头
     * @param rightEnd 第二个数组的尾
     * @param <AnyType> 数组的类型
     */
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a,
                                                                            AnyType[] tmpArray,
                                                                            int leftPos,
                                                                            int rightPos,
                                                                            int rightEnd) {
        int leftEnd = rightPos-1;  //左边数组的尾
        int tmpPos = leftPos; //临时数组的头
        int numElements = rightEnd-leftPos+1;  //元素个数
        //比较拷贝过程，直到一个数组被拷贝完
        while (leftPos <= leftEnd && rightPos <= rightEnd ){
            if(a[leftPos].compareTo(a[rightPos])<=0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];
        }

        while (leftPos <= leftEnd) //将左边剩余的数组拷贝到临时数组中
            tmpArray[tmpPos++] = a[leftPos++];
        while (rightPos <= rightEnd)//将右边剩余的数组拷贝到临时数组中
            tmpArray[tmpPos++] = a[rightPos++];
        //将临时数组拷贝回去
        for (int i=0;i<numElements;i++,rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];

    }

    /**
     * private类型的MergeSort方法的驱动程序
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a){
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a,tmpArray,0,a.length-1);
    }

    public static void main(String[] args) {
        Integer[] arr = {3,2,8,6,5,7};
        mergeSort(arr);
        for (int i:arr){
            System.out.println(i);
        }

    }


}

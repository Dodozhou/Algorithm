package sorting;

/**
 * 经典的插入排序。
 * 每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 */
public class InsertionSorting {
    /**
     * 插入排序的实现例程，特点是使用了泛型，可以接受任何实现了Comparable接口的类，
     * 并且使用了一种巧妙的方法避免了交换操作。
     * @param a 需要排序的数组
     * @param <AnyType> 数组的类型
     * @return 返回已经排好序的数组
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType[] insertionSort(AnyType a[]){
        int p;
        for (int i=1;i<a.length;i++){
            AnyType tmp=a[i];
            /*
            为什么要加上a[p]<a[p-1]这个循环控制条件呢？
            因为要让p停留在正确的位置，方便将tmp赋值
            这种方法避免了交换，全程只有赋值
             */
            for (p=i;p>0 && tmp.compareTo(a[p-1])<0 ; p--){
                a[p]=a[p-1];
            }
            a[p] = tmp;
        }

        return a;
    }

    /**
     * 验证插入排序正确性的程序
     * @param args 无
     */
    public static void main(String[] args) {
        Integer a[]={4,6,5,1};
        Integer result[]= insertionSort(a);
        for (int b : result) {
            System.out.println(b);
        }

    }
}

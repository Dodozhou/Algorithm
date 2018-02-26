package algorithm.sorting;

/**
 * 使用shell的增量序列的希尔排序实现
 */
public class ShellSorting {
    /**
     * 希尔排序的实现例程。
     * 希尔排序以增量进行分组，每一组进行组内的插入排序，使得该组有序。
     * @param a 要排序的数组
     * @param <AnyType> 数组的类型
     * @return 已经有序的数组
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType[] shellSort(AnyType[] a){
        int i;
        for (int gap=a.length/2;gap>0;gap/=2){ //增量序列
            /*
            * 下面就是插入排序*/
            for (int j=gap;j<a.length;j++) {   //从当前增量序列处开始向后遍历
                AnyType tmp = a[j];
                for (i = j; i>=gap && tmp.compareTo(a[i - gap]) < 0; i -= gap) {
                    a[i]=a[i-gap];
                }
                a[i]=tmp;
            }
        }
        return a;
    }

    /**
     * 验证插入排序正确性的程序
     * @param args 无
     */
    public static void main(String[] args) {
        Integer a[]={4,6,5,1};
        Integer result[]= shellSort(a);
        for (int b : result) {
            System.out.println(b);
        }

    }
}

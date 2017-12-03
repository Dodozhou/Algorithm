package search;

public class BinarySearch {
    /**
     * 二分查找法.
     * 通过二分查找法查找一个有序列表中某个数字的位置。
     * @param list 有序列表
     * @param target 要查找的数字
     * @return -1，目标不在列表中。其他数字，目标的位置（第几位，不是下标）
     */
    public static int binarySearch(int[] list,int target){
        int low=0;
        int high=list.length-1;
        int middle;
        for (int i=0;i<log(list.length,2);i++){
            middle=(low+high)/2;
            if (target==list[middle]){
                return middle+1;
            }else if (target<list[middle]){
                high=middle-1;
            }else {
                low=middle+1;
            }
        }
        return -1;
    }

    /*public static <AnyType extends Comparable<? super AnyType>> int binarySearch2(AnyType[] a,AnyType x){
        
    }*/

    /**
     * 计算以base为底，value的对数的静态方法.
     * 由于Java类库只提供了自然对数的计算方法，所以只有通过Math.log(value) / Math.log(base)
     * 来计算任意底的对数。
     * @param value 要计算的值
     * @param base 对数的底
     * @return 返回对数计算结果
     */
    public static  double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }


    public static void main(String[] args) {
        int[] list=new int[]{1,2,3,4,5,6};
        int position=binarySearch(list,1);
        if (position==-1){
            System.out.println("该数字不在list中！");
        }else {
            System.out.println("该数字的位置是第："+position);
        }
    }

}

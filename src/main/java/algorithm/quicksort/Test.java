package algorithm.quicksort;

public class Test {
    public static void main(String[] args) {
        Integer a[]={7,1,4,5,9,8,10,2};
        QuickSort2.quicksort(a);
        for (int i :a) {
            System.out.println(i);
        }
    }
}

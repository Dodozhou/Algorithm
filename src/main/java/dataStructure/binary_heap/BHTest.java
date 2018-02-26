package dataStructure.binary_heap;

public class BHTest {
    public static void main(String[] args) {
        Integer[] items={1,5,7,9,4,6,2,11,8,3};
        BinaryHeap<Integer> heap=new BinaryHeap<Integer>(items);
        Comparable[] arr= heap.getArr();
        for (Comparable item:arr){
            System.out.println(item);
        }
    }
}

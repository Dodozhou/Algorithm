package recursion;

import java.util.Scanner;

/**
 * 测试递归的小例子。
 * 有一个printDigit()方法每次只能输出一个0~9的数字，使用递归编写一个
 * 方法PrintOut()打印出连续的多个数字，如“78246”
 */
public class PrintNumTest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        printOut(in.nextInt());
    }

    public static void printOut(int n){
        if (n>9)
            printOut(n/10);
        printDigit(n%10);

    }

    public static void printDigit(int n){
        if (n>=0 && n<10){
            System.out.print(n);
        }else {
            System.out.print("x");
        }
    }
}



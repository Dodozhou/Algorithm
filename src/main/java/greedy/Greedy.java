package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Greedy {
    public static String caculate(String num,int k){
        Integer[] a=new Integer[num.length()];
        StringBuilder result= new StringBuilder();
        String[] b=num.split("");
        for(int i=0;i<b.length;i++){
            a[i]=Integer.parseInt(b[i]);
        }
        for (int j=0;j<k;j++){
            a=rem(a);
        }
        for (Integer anA : a) {
            result.append(anA);
        }
        return result.toString();
    }

    public static Integer[] rem(Integer[] a){
        Integer[] list=new Integer[a.length];
        int position=-1;
        for (int i=0;i<a.length-1;i++){
            if (a[i]>a[i+1]){
                position=i;
                break;
            }
        }
        for (int i=0;i<a.length-1;i++){
            if (i==position){
                list[i]=a[i+1];
            }else
                list[i]=a[i];
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(caculate("1432219",3));

    }
}

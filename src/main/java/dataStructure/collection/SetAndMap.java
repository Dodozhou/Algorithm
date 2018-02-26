package dataStructure.collection;

import sun.misc.ASCIICaseInsensitiveComparator;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * 测试TreeSet和TreeMap的类
 */
public class SetAndMap {
    public static void main(String[] args) {
        /*Set<String> set=new TreeSet(new ASCIICaseInsensitiveComparator());
        set.add("Hello");
        set.add("HeLLo");
        System.out.println(set.size());*/
        //遍历map的方法
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","zhou");
        map.put("2","cheng");
        map.put("3","zeng");
        Iterator iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}

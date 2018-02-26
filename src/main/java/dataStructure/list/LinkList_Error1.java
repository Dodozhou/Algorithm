package dataStructure.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LinkList_Error1 {
    public static void main(String[] args) {
        List<Integer> NumberList = new ArrayList<Integer>(Arrays.asList(2,4,1,3,5));

        for(int i = 0;i<NumberList.size();++i)
        {
            Integer v = NumberList.get(i);
            if(v%2 == 0)
            {
                NumberList.remove(v);//删除的是元素，而非下标
            }
        }

        Iterator it=NumberList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

package javaTest4;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个有序序列合并成一个有序序列
 */
public class list02 {

    public List<Integer> mergeList(List<Integer> list1,List<Integer> list2){
        List<Integer> merge = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)>list2.get(j)){
                merge.add(list2.get(j));
                j++;
            }else{
                merge.add(list1.get(i));
                i++;
            }
        }
        while(i<list1.size()){
            merge.add(list1.get(i));
        }
        while(j<list2.size()){
            merge.add(list2.get(i));
        }
        return merge;
    }
}

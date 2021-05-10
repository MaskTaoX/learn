package javaTest4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class suoyin01 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = 0x7fffffff;
        int len1 = list1.length, len2 = list2.length;
        ArrayList<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < len1; i++){
            map.put(list1[i], i);
        }
        for(int i = 0; i < len2; i++){
            if(map.containsKey(list2[i]))
            {
                if(i+map.get(list2[i])<min){
                    min = i + map.get(list2[i]);
                    list.clear();
                    list.add(list2[i]);
                }
                else if(i+map.get(list2[i])==min)
                {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

}

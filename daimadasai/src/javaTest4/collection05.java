package javaTest4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class collection05 {
    public static void main(String[] args) {
        String[][] array = new String[2][2];
        array[0][0]="Tom";
        array[0][1]="Array";
        array[1][0]="Tom";
        array[1][1]="Jack";
        //放到set
        Set<String> set = new HashSet<>();
        for(int i =0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                set.add(array[i][j]);
            }
        }
        set.stream().forEach(System.out::println);
        List<String> list = new ArrayList<>(set);
        list.stream().forEach(System.out::println);
    }

}

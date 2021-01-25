import org.junit.Test;
import 策略设计模式.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class testOptional {

    //终止操作
    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * nonematch-是否没有匹配所有元素
     */
    /**
     * 归约
     * 将流中元素反复结合起来
     * reduce(起始值，二元操作)
     * map-reduce操作
     */

    /**
     * 收集
     * collect-接受一个collector接口的实现
     * Collectors 工具类 用于产生collect的实例
     */
    List<Employee> employees= Arrays.asList(
            new Employee("zhang3",36,5000),
            new Employee("zhang4",40,6000),
            new Employee("zhang5",50,7000),
            new Employee("zhang6",25,9000),
            new Employee("zhang6",23,9000),
            new Employee("zhang6",21,9000),
            new Employee("zhang6",20,9000));

    List<String> a =Arrays.asList("111","222","333","444","555");
    List<String> b = Arrays.asList("333","444","555","666","777","888");
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //从0开始加 累加操作
        Integer sum = list.stream()
                        .reduce(0,(x,y)->x+y);

    }

    @Test
    public void test1(){
        List<Integer> l=employees.stream()
                                  .filter((e)->e.getName().equals("zhang6"))
                                    .map((e)->e.getAge())
                                    .collect(Collectors.toList());
        l.stream().forEach(System.out::println);
    }
    @Test
    public void test2(){
//        List<String> c = b.stream().filter((x)->!a.contains(x)).collect(Collectors.toList());
//        c.stream().forEach(System.out::println);

        String[] x=a.stream().toArray(String[]::new);
        Arrays.stream(x).forEach(System.out::println);
        System.out.println(x.length);
    }

    @Test
    public void test3(){
        Set<String> set=employees.stream().map(Employee::getName)
                        .collect(Collectors.toSet());
        HashSet<String> hashset = employees.stream().map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
    }

}

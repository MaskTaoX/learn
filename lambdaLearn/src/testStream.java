import org.junit.Test;
import 策略设计模式.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * 一。stream的三个操作步骤
 * 1.创建
 * 2.中间操作
 * 3.终止操作
 */

public class testStream {
    List<Employee> employees= Arrays.asList(
            new Employee("zhang3",36,5000),
            new Employee("zhang4",40,6000),
            new Employee("zhang5",50,7000),
            new Employee("zhang6",25,9000)
    );
    @Test
    public void test1(){
        //1.通过collection系列集合提供stream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法Stream获取数据流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("q","d");

        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0,(x)->x+2);
        stream3.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

    //中间操作 不会有任何结果 需要终止操作
        /*
            筛选与切片
            filter-接受lambda，从流中排除某些元素
            limit-截断流，元素不超过指定数量
            skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若元素不足n个 返回空流
            distinct-筛选，通过流所生成元素的hashcode()和equals去除重复元素
         */
    @Test
    public void test2(){
        employees.stream().filter((e)->e.getAge()>20).forEach(System.out::println);
    }
    //中间操作
    /*
            映射
            map-接收lambda，将元素转换成其他形式或提取信息。接受一个函数作为参数，该函数会被作用到每一个元素上，并将其映射为一个新元素。
            flatmap-接受一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test3(){
        List<String> list= Arrays.asList("aaa","bbb","ccc");
        list.stream().map((str)->str.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        //提取全部名字
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}

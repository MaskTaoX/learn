import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * “->”将表达式拆分成两部分
 * 左侧：lambda表达式中参数（抽象方法中参数列表）
 * 右侧：lambda表达式中需要执行的功能 （抽象方法的实现）
 * 适用于 函数式接口
 * 本质就是一个函数式接口的实现
 * 语法格式一： 无参数 无返回值
 *      ()->System.out.printlin("hello");
 * 语法格式二： 有参数 无返回值
 * 语法格式三：如果方法只有一个参数 小括号可以不写
 * 语法格式四：有两个以上参数 有返回值 并且lambda中有多条语句
 * 语法格式五：如果只有一条语句 大括号和return都可以不写
 * 语法格式六：数据类型可以省略
 *
 *
 *
 * @FunctionalInterface 注解 确保接口是函数式接口
 */
public class testLambda2 {
    @Test
    public void test1() {
        Runnable r1= ()->System.out.println("hello");
        r1.run();
    }
    @Test
    public void test2(){
        /**
         * lamdba表达式是对Consumer接口的accept方法的实现
         */
        Consumer<String> consumer = (x)->System.out.println(x);
        consumer.accept("aaaa");
    }
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->{
            System.out.println("函数是借口");
            return Integer.compare(x,y);
        };

        Comparator<Integer> co=(x,y)->Integer.compare(x,y);
    }

}

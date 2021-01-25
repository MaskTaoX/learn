package 策略设计模式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testLambda {
    public static void main(String[] args) {

        List<Employee> employees= Arrays.asList(
            new Employee("zhang3",36,5000),
            new Employee("zhang4",40,6000),
            new Employee("zhang5",50,7000),
            new Employee("zhang6",25,9000)
        );

        //将不同过滤规则的实例传入
        //按照年龄过滤
        List<Employee> list1=filter(employees,new FilterEmployeeByAge());
        //按照薪资过滤
        List<Employee> list2=filter(employees,new FilterEmployeeBySalary());

        /**
         * 优化方法2 匿名内部类
         */
        List<Employee> list3=filter(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()>=1000;
            }
        });

        /**
         * 优化方法3 lambda表达
         */
        List<Employee> list4 = filter(employees,(e)->e.getSalary()>=2000);
        list4.forEach(System.out::println);

        /**
         * 优化方式4
         */
        employees.stream()
                 .filter((e)->e.getSalary()<=10000)
                 .forEach(System.out::println);
        //拿出全部名字
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    /**
     *优化方法1 策略模式
     * @param list 要过滤的列表
     * @param mp 要过滤使用的规则
     * @return
     */
    public static  List<Employee> filter(List<Employee> list , MyPredicate<Employee> mp){
        List<Employee> re = new ArrayList<>();
        for(Employee employee : list){
            if(mp.test(employee)){
                re.add(employee);
            }
        }
        return  re;
    }
}

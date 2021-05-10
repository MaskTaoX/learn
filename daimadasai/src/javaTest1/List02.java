package javaTest1;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * list中元素是person类 写一个方法 找出list中年龄最大的三个男人名字
 */
public class List02 {
    public static List<Person> personList = Arrays.asList(
            new Person("zhangsan",18,"nan"),
            new Person("lisi",14,"nan"),
            new Person("wangsu",25,"nan"),
            new Person("zhaoliu",20,"nan"),
            new Person("zhangqi",34,"nv"),
            new Person("yeba",48,"nan"),
            new Person("zhang",38,"nv"),
            new Person("anli",28,"nv")
    );

    public static void main(String[] args) {
        List<String> names = personList.stream()
                .filter((e)->e.getSex().equals("nan"))
                //.sorted(Comparator.comparing(Person::getAge).reversed())
                .sorted((e1,e2)->e1.getAge()-e2.getAge())
                .map((e)->e.getName())
                .limit(3)
                .collect(Collectors.toList());
        names.stream().forEach(System.out::println);

     }

}

class Person{
    private String name;
    private Integer age;
    private String sex;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
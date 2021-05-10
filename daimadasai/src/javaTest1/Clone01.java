package javaTest1;

/**
 * 在java中通过clone方法复制某个对象 该类中必须实现Cloneable接口
 * 深浅拷贝问题
 * Java 将内存空间分为堆和栈。基本类型直接在栈中存储数值，而引用类型是将引用放在栈中，实际存储的值是放在堆中，通过栈中的引用指向堆中存放的数据。
 * 基本类型也称为值类型，分别是字符类型 char，布尔类型 boolean以及数值类型 byte、short、int、long、float、double。
 * 引用类型则包括类、接口、数组、枚举等。
 *
 * 解决方法 引用类型new一个
 * 
 */
public class Clone01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Province province = new Province("qwe");
        StudentClone studentClone = new StudentClone("2",province);
        StudentClone studentClone1 = (StudentClone)studentClone.clone();
        studentClone1.getProvince().setName("asd");
        System.out.println("深拷贝");
        System.out.println(studentClone.getProvince().getName());
        System.out.println(studentClone1.getProvince().getName());
    }
}

class Province implements Cloneable{
    private String name;

    public Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable{
    private String name;
    private Province province;

    public Student(String name, Province province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class StudentClone implements Cloneable{
    private String name;
    private Province province;

    public StudentClone(String name, Province province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        StudentClone tmp = (StudentClone) super.clone();
        tmp.province=(Province)province.clone();
        return tmp;
    }
}
package 策略设计模式;

public class FilterEmployeeByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=35;
    }
}

package 策略设计模式;

@FunctionalInterface
public interface MyPredicate<T>{
    boolean test(T t);
}

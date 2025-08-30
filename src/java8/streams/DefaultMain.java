package java8.streams;

public class DefaultMain implements DefaultExample1,DefaultExample2 {
    public static void main(String[] args) {
        DefaultExample1 defaultExample = new DefaultMain();
        defaultExample.defaultMethod();
        Square s = x->{
            return x*x;
        };
        System.out.println(s.calculate(5));
    }

    @Override
    public void defaultMethod() {
        DefaultExample2.super.defaultMethod();
    }
}

import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        //FUNCTION .aply()
        Function<String, Integer> func = Integer::parseInt;
        Function<Integer, Integer> xxx = a -> a+3;

        Function<String, Integer> aa = func.andThen(xxx);
        xxx.compose(func);  //parametri so obratni

        func.apply("12");
        int sss = aa.apply("12");  //sss = 15

        //SUPLIER .get()
        Supplier<Integer> sa = () -> 3;

        String name = "bob";
        Supplier<String> x = name::toUpperCase;
        System.out.println(x.get());

        //CONSUMER .accept()
        Consumer<String> ss = (String a) -> System.out.println(a);
        Consumer<String> ssIsto = System.out::println;
        ss.accept("8");
        ss.andThen(ssIsto);  //lahko chainas consumerje

        //OPERATOR(consume&produces same type) .aply()
        BinaryOperator<Integer> bin = (i,j) -> i+j+1;
        bin.apply(1,2);

        UnaryOperator<Integer> un = i-> i+1;
        un.apply(3);

    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Lambdaa {

    public static void main(String[] args) {


        /////   1. Function 인터페이스의 예시     /////

        // 1-1. 익명 클래스를 사용한 예시
        Function<String, Integer> stringIntegerFunction = new Function<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Integer anonymousResult = stringIntegerFunction.apply("Hello");
        System.out.println(anonymousResult);   // 5 출력

        // 1-2. 람다식을 사용한 예시
        Function<String, Integer> stringLengthFunction_lambda = s -> s.length();
        Integer lambdaResult = stringLengthFunction_lambda.apply("Hello");
        System.out.println(lambdaResult);  // 5 출력

        // 1-3. 메서드 참조를 사용한 예시
        Function<String, Integer> stringLengthFunction_methodReference = String::length;
        Integer methodRefResult = stringLengthFunction_methodReference.apply("Hello");
        System.out.println(methodRefResult);  // 5 출력

        // 1-3-0. 메서드 참조 추가 예시
        // 1-3-1) 정적 메서드 참조 메서드 참조
        IntFunction<Double> sqrt = Math::sqrt;  // IntFunction<Double> -> Integer 입력, Double 리턴
        Double sqrtResult = sqrt.apply(16);
        System.out.println("sqrtResult = " + sqrtResult); // 4.0 출력

        // 1-3-2) 특정 객체의 인스턴스 메서드 참조
        String str = "hello";
        Supplier<String> toUpperCase = str::toUpperCase;
        System.out.println(toUpperCase.get());

        // 1-3-3) 클래스의 인스턴스 메서드 참조
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.sort(String::compareToIgnoreCase);
        System.out.println("names = " + names);

        // 1-3-4) 생성자 참조
        Supplier<ArrayList<String>> createList = ArrayList::new;
        ArrayList<String> list = createList.get();
        System.out.println("list = " + list);


    }


}

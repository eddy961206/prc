import java.util.function.Function;

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


    }


}

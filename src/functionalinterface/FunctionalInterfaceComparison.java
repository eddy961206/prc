package functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.Random;

// 1. Function<T, R> 예제
/**
 * Function<T, R>
 *   R apply(T t)
 * - T를 인자로 받고, R을 리턴합니다.
 * - 이름 의미: 수학에서 함수(Function)는 입력값을 받아 출력값을 반환하는 관계를 의미하는 것처럼,
 *   Java의 Function도 입력값을 다른 값으로 변환하는 함수를 표현하기 위해 이름 지어졌습니다.
 * - 용도 : 데이터 변환, 매핑 작업 등에 주로 사용
 */
class FunctionExampleWithout {
    public static void run() {
        System.out.println("== Function<T, R> Without ==");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        StringLengthCalculator calculator = new StringLengthCalculator();

        List<Integer> lengths = new ArrayList<>();
        for (String name : names) {
            lengths.add(calculator.getLength(name));
        }

        System.out.println("Lengths: " + lengths);  //  [5, 3, 7]
    }
}

class StringLengthCalculator {
    public Integer getLength(String s) {
        return s.length();
    }
}

class FunctionExampleWith {
    public static void run() {
        System.out.println("== Function<T, R> With ==");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Function 인터페이스 사용
        Function<String, Integer> lengthFunction = String::length;

        // 스트림과 Function을 이용한 변환
        List<Integer> lengths = names.stream()
                                     .map(lengthFunction)   // Function은 특정 인자를 받고 리턴까지.
                                     .collect(Collectors.toList());

        System.out.println("Lengths: " + lengths);  //  [5, 3, 7]
    }
}

// 2. Consumer<T> 예제
/**
 * Consumer<T>
 * - void accept(T t)
 * - T를 인자로 받고, 이를 소모합니다.(리턴 X)
 * - 이름 의미: Consumer는 '소비자'라는 의미로, 값을 받아서 소비만 하고
 *   아무것도 반환하지 않는 동작을 표현하기 위해 이름 지어졌습니다.
 * - 용도 : 데이터 처리, 출력, 로깅 등에 주로 사용
 */
class ConsumerExampleWithout {
    public static void run() {
        System.out.println("\n== Consumer<T> Without ==");
        List<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("World");
        messages.add("!");

        Printer printer = new Printer();

        for (String msg : messages) {
            printer.print(msg);
        }
    }
}

class Printer {
    public void print(String s) {
        System.out.println(s);
    }
}

class ConsumerExampleWith {
    public static void run() {
        System.out.println("\n== Consumer<T> With ==");
        List<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("World");
        messages.add("!");

        // Consumer 인터페이스 사용
        Consumer<String> printer = System.out::println;

        // 스트림과 Consumer를 이용한 처리
        messages.forEach(printer);  // Counsumer는 인자 받고 리턴 없이 소모
    }
}

// 3. Predicate<T> 예제
/**
 * Predicate<T>
 * - boolean test(T t)
 * - T를 인자로 받고, Boolean형을 리턴합니다.
 * - 이름 의미: Predicate는 '단정문' 또는 '술어'라는 의미로,
 *   주어진 입력값에 대해 참/거짓을 판단하는 논리적 함수를 표현하기 위해 이름 지어졌습니다.
 * - 용도 : 조건 검사, 필터링, 조건부 실행 등에 주로 사용
 */
class PredicateExampleWithout {
    public static void run() {
        System.out.println("\n== Predicate<T> Without ==");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 16));
        people.add(new Person("Charlie", 25));

        AgeChecker checker = new AgeChecker();

        List<Person> adults = new ArrayList<>();
        for (Person p : people) {
            if (checker.isAdult(p)) {
                adults.add(p);
            }
        }

        System.out.println("Adults: " + adults);
    }
}

class AgeChecker {
    public boolean isAdult(Person p) {
        return p.getAge() >= 18;
    }
}

class PredicateExampleWith {
    public static void run() {
        System.out.println("\n== Predicate<T> With ==");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 16));
        people.add(new Person("Charlie", 25));

        // Predicate 인터페이스 사용
        Predicate<Person> isAdult = p -> p.getAge() >= 18;

        // 스트림과 Predicate를 이용한 필터링
        List<Person> adults = people.stream()
                                    .filter(isAdult)    //  Predicate는 인자를 받고 Boolean 리턴
                                    .collect(Collectors.toList());

        System.out.println("Adults: " + adults);
    }
}

// 4. Supplier<T> 예제
/**
 * Supplier<T>
 * - T get()
 * - T를 리턴합니다.(Lazy Evaluation)
 * - 이름 의미: Supplier는 '공급자'라는 의미로,
 *   아무런 입력 없이 값을 제공(공급)하는 동작을 표현하기 위해 이름 지어졌습니다.
 * - 용도 : 데이터 공급, 지연 평가, 랜덤 값 생성, 팩토리 메서드, 초기화 로직 등에 주로 사용
 */
class SupplierExampleWithout {
    public static void run() {
        System.out.println("\n== Supplier<T> Without ==");
        RandomNumberGenerator generator = new RandomNumberGenerator();

        System.out.println("Random Number: " + generator.getRandomNumber());
    }
}

class RandomNumberGenerator {
    private Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(100);
    }
}

class SupplierExampleWith {
    public static void run() {
        System.out.println("\n== Supplier<T> With ==");
        Random random = new Random();

        Supplier<Integer> randomSupplier = () -> random.nextInt(100);

        System.out.println("Random Number: " + randomSupplier.get());   // Supplier는 인자 없이 리턴만
    }
}

// Person 클래스
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

// 메인 클래스
public class FunctionalInterfaceComparison {
    public static void main(String[] args) {
        // Function<T, R> 예제
        FunctionExampleWithout.run();
        FunctionExampleWith.run();

        // Consumer<T> 예제
        ConsumerExampleWithout.run();
        ConsumerExampleWith.run();

        // Predicate<T> 예제
        PredicateExampleWithout.run();
        PredicateExampleWith.run();

        // Supplier<T> 예제
        SupplierExampleWithout.run();
        SupplierExampleWith.run();
    }
}

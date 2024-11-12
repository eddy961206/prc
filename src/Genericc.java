import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Genericc {

    public static void main(String[] args) {

        ////  1. extends를 사용한 상한 제한   /////
        // '? extends Type' 은 주로 데이터 "읽을 때" 사용 (상한 제한, 이하로 가능)
        List<? extends Number> list = new ArrayList<Integer>();
        /* list.add(10); */
        // add 는 컴파일 에러 : '? extends Number' 는 쓰기 불가 -> '?' 자리에 들어갈 수 있는 타입이 무엇이 올지 모르기 때문에

//        Number num = list.get(0);   // 읽기만 가능


        ////   2. super를 사용한 하한 제한   /////
        // '? super Type' 은 주로 데이터 "쓸 때" 사용 (하한 제한, 이상으로 가능)
        List<? super Integer> list2 = new ArrayList<Number>();
        list2.add(10);
        list2.add(20);
        Integer num2 = (Integer) list2.get(0);   // 읽을 때는 Object 타입으로만 받기 때문에 형변환 필요
        System.out.println("num2 = " + num2);

        printList(list2);

        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0);
        sumOfList(doubleList);

        List<Number> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        addIntegers(integerList);   // 결과 : addIntegers = [1, 2, 3, 10, 20, 30]
        System.out.println("integerList = " + integerList); // 결과 : integerList = [1, 2, 3, 10, 20, 30] --> 원본 리스트가 변경됨

    }

    // 제네릭 메서드에서 와일드카드(*) 사용 예시
    public static void printList(List<?> list) { //  어떤 타입의 리스트든 받아서 출력 가능
        System.out.println("--- printList ---");
        for (Object element : list) {
            System.out.println(element);
        }
    }

    // extends를 사용한 예시
    public static void sumOfList(List<? extends Number> list) { // Number의 하위 타입(Integer, Double 등)으로 구성된 리스트의 합계 계산
        System.out.println("--- sumOfList ---");
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        System.out.println("sumOfList = " + s);
    }

    // super를 사용한 예시
    public static void addIntegers(List<? super Integer> list) { //  Integer의 상위 타입(Integer, Number, Object)의 리스트에 Integer 추가
        System.out.println("--- addIntegers ---");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("addIntegers = " + list);
    }

}

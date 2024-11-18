import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Genericc {

    public static void main(String[] args) {

        ////  1. extends를 사용한 상한 제한   /////
        // '? extends Type' 은 주로 데이터 "읽을 때" 사용 (상한 제한, 이하로 가능)
        List<? extends Number> numbersExtendsList = new ArrayList<Integer>();
        /* list.add(10); */
        // add 는 컴파일 에러 : '? extends Number' 는 쓰기 불가 -> '?' 자리에 들어갈 수 있는 타입이 무엇이 올지 모르기 때문에

//        Number num = list.get(0);   // 읽기만 가능


        ////   2. super를 사용한 하한 제한   /////
        // '? super Type' 은 주로 데이터 "쓸 때" 사용 (하한 제한, 이상으로 가능)
        List<? super Integer> numbersSuperList = new ArrayList<Number>();
        numbersSuperList.add(10);
        numbersSuperList.add(20);
        Integer retrievedNumber = (Integer) numbersSuperList.get(0);   // 읽을 때는 Object 타입으로만 받기 때문에 형변환 필요
        System.out.println("하한 제한 리스트(super)에서 가져온 숫자: " + retrievedNumber);

        printListContents(numbersSuperList);

        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0);
        sumOfList(doubleList);

        List<Number> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        addIntegers(integerList);   // 결과 : addIntegers = [1, 2, 3, 10, 20, 30]
        System.out.println("integerList = " + integerList); // 결과 : integerList = [1, 2, 3, 10, 20, 30] --> 원본 리스트가 변경됨

        Integer firstInt = getFirstElement(new Integer[]{1, 2, 3});
        Number firstNum = getFirstElement(new Number[]{10, 20, 30});
        System.out.println(firstInt + " " +  firstNum);


        GenericBox<Number> numberBox = new GenericBox<>(100);
        // 1. 클래스 레벨의 타입 파라미터 T(Number) 사용
        Number classLevelItem = numberBox.getItemUsingClassLevelType();
        System.out.println("클래스 레벨 T 사용 결과: " + classLevelItem);    // 출력 : 100
        System.out.println("클래스 레벨 T 사용 결과 클래스 : " + classLevelItem.getClass());    // Number 아님. Integer. 컴파일 할 때만 Number로 간주, 실제 런타임에는 '100' 이 들어갔으므로 Integer 로 인식됨
        // 컴파일 이후 모든 제네릭 타입은 Object로 변환. 타입 정보는 컴파일러가 에러를 방지하기 위해 사용하는 것이지, 런타임에 영향을 주지 않음.

        // 2. 메서드 레벨의 타입 파라미터 T (유연하게 타입 변환 가능) 사용
        Integer intMethodLevelItem = numberBox.getItemWithMethodLevelType();
        System.out.println("메서드 레벨 타입(Integer)으로 변환: " + intMethodLevelItem);  // 출력: 100
        System.out.println("메서드 레벨 타입(Integer)으로 변환 결과 클래스 : " + intMethodLevelItem.getClass());  // 출력: class java.lang.Integer

        try {
            Double doubleMethodLevelItem = numberBox.<Double>getItemWithMethodLevelType();
            System.out.println("메서드 레벨 타입(Double)으로 변환: " + doubleMethodLevelItem);  // 출력: 100.0 안되고 에러남. 이미 100 이라는 Integer 값이 들어가 있기 때문에 에러 발생
        } catch (ClassCastException e) {
            System.out.println("타입 변환 실패: " + e.getMessage());  // class java.lang.Integer cannot be cast to class java.lang.Double
        }

    }

    // 제네릭 메서드에서 와일드카드(?) 사용 예시
    public static void printListContents(List<?> list) { //  어떤 타입의 리스트든 받아서 출력 가능
        System.out.println("printListContents 내용 출력:");
        for (Object element : list) {
            System.out.println("- " + element);
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

    // 제네릭 메서드 정의
    public static <T extends Number> T getFirstElement(T[] array) {  //  리턴타입 앞의 <T ~~ > : 제네릭 메서드임을 나타냄
        return array[0];
    }


    // 제네릭 클래스 정의
    public static class GenericBox<T> { // 여기서 T : 클래스 레벨에서 사용되는 제네릭 타입 매개변수 (범위 : 클래스 전체)
        private T item;

        public GenericBox(T item) {
            this.item = item;
        }

        // 클래스 레벨 T 사용
        public T getItemUsingClassLevelType() { // 제네릭 '클래스' 안에서는 제네릭 메서드의 리턴타입 앞에 <T> 를 붙이지 않아도 됨
            return item;
        }

        // 메서드 레벨 T 사용 (타입 지정 가능)
        public <T> T getItemWithMethodLevelType() {    // 메서드 선언에서 <T> 붙이면 이 T 는 메서드 레벨에서만 사용되는 새로운 타입 매개변수.
            // 따라서 메서드의 타입 매개변수 T는 클래스의 타입 매개변수 T와 완전히 별개.
            return (T) item;    // 따라서 메서드 레벨에서 사용되는 T로 형변환 해서 리턴해줘야.
        }
    }

}

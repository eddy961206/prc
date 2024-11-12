import java.util.ArrayList;
import java.util.List;

public class Genericc {

    public static void main(String[] args) {

        // 1. extends를 사용한 상한 제한
        // ? extends Type 은 주로 데이터 읽을 때 사용 (상한 제한, 이하로 가능)
        List<? extends Number> list = new ArrayList<Integer>();
        /* list.add(10); */   // 컴파일 에러 : ? extends Number 는 쓰기 불가
        Number num = list.get(0);   // 읽기만 가능

        // 2. super를 사용한 하한 제한
        // ? super Type 은 주로 데이터 쓸 때 사용 (하한 제한, 이상으로 가능)
        List<? super Integer> list2 = new ArrayList<Number>();
        list2.add(10);
        Integer num2 = (Integer) list2.get(0);   // 읽을 때는 Object 타입으로만 받기 때문에 형변환 필요

    }

}

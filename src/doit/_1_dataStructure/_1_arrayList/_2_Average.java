package doit._1_dataStructure._1_arrayList;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/1546
* https://www.youtube.com/watch?v=31Z1tH5frYY&ab_channel=%ED%95%98%EB%A3%A8%EC%BD%94%EB%94%A9
*
* 1. 아이디어
* - 입력
* 1번째 줄 : 시험 종목 개수(N), N<=1000
* 2번째 줄 : 각 시험당 점수 ('40 80 100')
*
* - 출력
* 새로운 점수들의 평균 (새로운 점수 : 원시험점수/M*100)
* M: 원시험점수들 중 가장 높은 점수
*
* N은 int군. nextInt() 로 받자. 변수명은 N
* 시험당 점수는 N만큼 반복해서 nextInt()로 받자. 받은 걸 int[] 에 넣자.
* 평균은 Math.average 쓰면되나? 찾아보자.
* 평균구하는 건 라이브러리 없는거같다. 그냥 전체 더한다음 총 개수로 나누자.
* 새로운 점수를 구하려면 M을 구해야지. -> 저장해야지
* M은 int[] 중에 최댓값이다. Math.max 있지 않나? 그거 쓰면 될거야.
* int[] 를 반복문 돌면서 각 요소를 M으로 나누고 * 100을 해주자.
* 그리고 그걸 따로 변수에 담아놓지 말고 그냥 바로 평균 계산하자.
* 그런데 굳이 각 요소 하나하나마다 새롭게 계산하고 평균 때리나
* 원래 평균에 새롭게 계산 한번만 하나 같은거 아닌가? 같음.
* 따라서 그냥 원래의 평균 구하고 M 나누고 * 100하자.
*
*
*
*
* 새로 배운것 :
* 1. int끼리 나눌 때 나눗셈 제대로 하려면 나눗셈 연산에서
* 적어도 하나의 피연산자를 실수형으로 만들어야 함 (double avg = sum / (double) N)
* 1-1. 아니면 .0을 붙여서 자동으로 실수로 변환되게 하던가.
* 2. 굳이 arr 에 저장 안하고 temp로 받아서 바로 처리해도 됨.
*
* */
public class _2_Average {

    static void 내풀이(Scanner sc) {

        int N = sc.nextInt();

        int[] arr = new int[N];
        int sum = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();  // 굳이 arr 에 저장 안하고 temp로 받아서 바로 처리해도 됨
            sum += arr[i];
            if (M < arr[i]) {
                M = arr[i];
            }
        }
        double avg = (double)sum / N;
//        double newAvg = avg / M * 100;

        double newAvg = sum * 100.0 / M / N;

        System.out.println("avg = " + avg);
        System.out.println("newAvg = " + newAvg);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        내풀이(sc);

        sc.close();
    }
}

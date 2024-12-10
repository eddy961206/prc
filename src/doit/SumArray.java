package doit;

public class SumArray {

    /* 합배열

     * 1. 문제: 주어진 정수 배열의 연속된 원소들의 부분합의 최대 값을 구하시오.
     * 예제 입력: [2, 1, -3, 4, -1, 2, 1, -5, 4]
     * 예제 출력: 6 (부분합은 [4, -1, 2, 1]의 합)
     */



    /*
     *
     * 일단 모든 부분합들 경우 하나씩 비교해가며 최대값 구하는걸로 해보자
     *
     * 3중for문 필요할듯.
     * 왜? 시작요소에 위치에 대한 바깥반복, 끝요소 위치에 대한 중간쪽반복, 누적합 구하는 안쪽반복
     * 끝요소는 시작요소보다 커야함
     * 필요 변수 : max, startIdx, endIdx, sum
     *
     * */
    static void 무지성3중for문(int[] arr) {
        int max = 0;
        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum > max) {
                    max = sum;
                    startIdx = i;
                    endIdx = j;
                }
                System.out.println("arr[i]:" + arr[i] + " arr[j]:" + arr[j] + "  sum : " +  sum);
            }
        }
        System.out.println("최대인 합배열 시작 인덱스 : " + startIdx + ", 끝 인덱스 : " + endIdx + ", 최대값: " + max);

    }




    public static void main(String[] args) {
        int[] arr = {2, 1, -3, 4, -1, 2, 1, -5, 4};
        무지성3중for문(arr);
    }
}

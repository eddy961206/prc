package backjoon;

/* https://www.acmicpc.net/problem/11659 */

/*
*
* 1. 아이디어
* - 입력
* 첫째 줄 : n과 m ('5 3')
* 둘째 줄 : n개 요소의 숫자배열 ('5 4 3 2 1')
* 세번째 줄 ~ : 총 m개의 시작,끝 인덱스 쌍 ('1 3'\n'2 4'\n'5 5')
* 시작, 끝 인덱스 쌍 m개 는 2개짜리 숫자배열에 담기 -> m 개의 int[2] 배열 -> m번 반복해야.
*
* - 출력
* 첫번째 시작, 끝 인덱스 쌍에 해당하는 구간합
* 두번째 시작, 끝 인덱스 쌍에 해당하는 구간합
* ...
* m 번째 시작, 끝 인덱스 쌍에 해당하는 구간합 -> m번 반복해야.
*
* - 누적 합 배열 사용: 배열의 i번째 요소까지의 누적 합을 저장하는 배열을 생성
* - 부분 합 계산: 누적 합 배열을 이용하여 j번째 요소까지의 합에서
* i-1번째 요소까지의 합을 빼면 i번째부터 j번째 요소까지의 합을 구할 수
*
* 2. 시간 복잡도
* - 누적 합 배열 생성: O(N)
* - 각 쿼리에 대한 부분 합 계산: O(1)
* - 전체 쿼리 처리: O(M)
* - 따라서 전체 시간 복잡도는 O(N + M) 입니다.
*
* 3. 자료구조
* - 입력 배열: int[]
* - 누적 합 배열: int[]
* - 쿼리: int[][] 또는 별도의 클래스 (i, j 저장)
*
*/

import java.util.Scanner;

public class SegmentSum {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] query = new int[m][2];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < 2; i++) {
                query[j][i] = sc.nextInt();
            }
        }



        sc.close();
    }


}

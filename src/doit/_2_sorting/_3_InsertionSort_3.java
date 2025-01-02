package doit._2_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *
 * https://www.acmicpc.net/problem/11399
 *
 **** 0. 문제 정리 ****
 * 제한 : 1초, 128MB
 * 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000), 둘째 줄 각 사람이 돈을 인출하는데 걸리는 시간 Pi(1 ≤ Pi ≤ 1,000)
 **** 1. 알고리즘 ****
 * 삽입정렬로 오름차순 정렬해서 합 구하기
 **** 2. 시간복잡도 ****
 * 삽입정렬 -> O(N2)
 *
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
* 5
* 3 1 4 3 2
* */

public class _3_InsertionSort_3 {
    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = N - i; j > 0; j--) {
//                sum += arr[j - 1];
//            }
//        }

        // 합배열 만든 이후 총 합 구하기
//        int[] S = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            S[i] = S[i - 1] + arr[i - 1];
//        }
//
//        int sum = 0;
//        for (int i = 0; i <= N; i++) {
//            sum += S[i];
//        }
//        System.out.println(sum);

        // 합배열 안만들고 바로 누적합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (N - i) * arr[i];
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

package doit._2_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 *
 * https://www.acmicpc.net/problem/24051
 *
 **** 0. 문제 정리 ****
 * 제한 : 1초, 128MB
 * 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 10,000), 저장 횟수 K(1 ≤ K ≤ N2)가 주어진다.
 **** 1. 알고리즘 ****
 *
 **** 2. 시간복잡도 ****
 * O(N2) ->
 *
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
* */

public class _3_InsertionSort_2 {
    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 삽입정렬
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            boolean isReplaced = false;
            while (j>=0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                cnt++;
                if (cnt == K) {
                    System.out.println(arr[j]);
                    return;
                }
                j--;
                isReplaced = true;
            }
            if (isReplaced) {
                arr[j + 1] = key;
                cnt++;
                if (cnt < K) {
                    System.out.println("-1");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

package doit._2_sorting;

import java.io.IOException;
import java.util.Scanner;
/*
 *
 * https://www.acmicpc.net/problem/2750
 *
 **** 0. 문제 정리 ****
 * 제한 : 1초, 128MB
 * 1 <= N <= 1,000
 **** 1. 알고리즘 ****
 *
 **** 2. 시간복잡도 ****
 * O(N2) -> 백만
 *
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
* */

public class _3_InsertionSort {
    static void 내풀이() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 오름차순
        for (int i = 1; i < N; i++) {
            int key = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }
    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

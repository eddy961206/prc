package doit._2_sorting;
import java.io.*;
import java.sql.Array;
import java.util.*;
/*
 *
 * https://www.acmicpc.net/problem/11286
 *
 **** 0. 문제 정리 ****
 * 제한 : 1초, 128MB
 * 1 <= N <= 1000
 **** 1. 알고리즘 ****
 * 버블정렬
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

public class _1_BubbleSort {
    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N - 1; i++) {
            boolean isSwaped = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwaped = true;
                }
            }
            if (!isSwaped) break;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

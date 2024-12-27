package doit._2_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 *
 * https://www.acmicpc.net/problem/1427
 *
 **** 0. 문제 정리 ****
 * 제한 : 1초, 128MB
 * 1 <= N <= 10억
 **** 1. 알고리즘 ****
 *  선택정렬
 * 최대 10자리라서 sc.nextInt로 받을 수 없음. int 범위 초과
 * sc.next로 String으로 받은 후 각 자리를 배열에 넣기
 * 내림차순 정렬
 *
 **** 2. 시간복잡도 ****
 * O(N2) -> 10자리면 100
 *
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
* */

public class _2_SelectionSort {
    static void 내풀이() throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] charArray = input.toCharArray();
        int N = input.length();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Character.getNumericValue(charArray[i]);
        }
        // [1, 4, 2, 5, 9]
        for (int i = 0; i < N - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            if (arr[i] < arr[maxIdx]) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
        }

    }

    static void 답풀이() throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = str.length();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int i = 0; i < N; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[maxIdx] < arr[j]) maxIdx = j;
            }
            if (arr[i] < arr[maxIdx]) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
        }

    }

    static void 답풀이연습() throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = str.length();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < N - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            if (arr[i] < arr[maxIdx]) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }

        for (int e : arr) {
            System.out.print(e);
        }

//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i]);
//        }
    }

    public static void main(String[] args) throws IOException {
//        내풀이();
//        답풀이();
        답풀이연습();
    }
}

package doit._3_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 *
 * https://www.acmicpc.net/problem/1920
 *
 **** 0. 문제 정리 ****
 *  1 초	128 MB
 ** 문제 **
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 ** 입력 **
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
 * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
 * 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 ** 출력 **
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 *
 **** 1. 알고리즘 ****
 * 이진 탐색
 *
 **** 2. 시간복잡도 ****
 * 정렬 - nlogn
 * 이진탐색 - nlogn
 * 총 - nlogn
 *
 **** 3. 자료구조 ****
 *
 */
/*
* 입력 예시
* */
public class _3_BinarySearch {

    static void 답풀이() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = A.length - 1;
            while (start <= end) {
                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];
                if (mid_value > target) {
                    end = mid_index - 1;
                } else if (mid_value < target) {
                    start = mid_index + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) System.out.println(1);
            else System.out.println(0);
        }
    }

    static void 복습1() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid_idx = (start +end) / 2;
                int mid_val = A[mid_idx];
                if (target > mid_val) {
                    start = mid_idx + 1;
                } else if (target < mid_val) {
                    end = mid_idx - 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) System.out.println(1);
            else System.out.println(0);
        }

    }


    public static void main(String[] args) throws IOException {
        답풀이();
    }

}

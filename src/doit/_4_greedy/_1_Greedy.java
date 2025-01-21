package doit._4_greedy;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * https://www.acmicpc.net/problem/11047
 *
 **** 0. 문제 정리 ****
 *  1 초	128 MB
 ** 문제 **
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 ** 입력 **
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 ** 출력 **
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력.
 *
 **** 1. 알고리즘 ****
 * A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수 -> 그리디 알고리즘 가능
 * Ai 마다 몫이 가장 작은애
 *
 **** 2. 시간복잡도 ****
 *
 **** 3. 자료구조 ****
 *
 */
/*
* 입력 예시
* */
public class _1_Greedy {

    static void 답풀이() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                cnt += K / A[i];
                K = K % A[i];
                if (K == 0) break;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        답풀이();
    }

}

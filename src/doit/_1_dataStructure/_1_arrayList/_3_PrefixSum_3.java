package doit._1_dataStructure._1_arrayList;

import java.io.*;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/10986
*
**** 0. 문제 정리 ****
* 제한 : 1초, 256MB
*
**** 1. 알고리즘 ****
*
*
**** 2. 시간복잡도 ****
*
**** 3. 자료구조 ****
*
/*
* 입력 예시
*   5 3
    1 2 3 1 2
* */
public class _3_PrefixSum_3 {

    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];
        int[] M = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        // 누적합배열 S 만들기
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
            M[i] = (int) (S[i] % m);
        }

        int[] M0;
        int cnt0 = 0;
        for (int i = 0; i < n; i++) {
            if (M[i] == 0) {
                cnt0++;
            } else {

            }
        }



    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

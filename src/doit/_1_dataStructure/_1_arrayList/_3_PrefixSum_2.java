package doit._1_dataStructure._1_arrayList;

import java.io.*;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/11660
*
**** 0. 문제 정리 ****
* 제한 : 1초, 256MB
* n = 4, m = 3 -> 4x4 행렬에서 3번의 질의에 대한 답 출력해야 (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
* 각 질의는 x1 y1 x2 y2 형태로 입력받음
* (x1,y1) 과 (x2,y2) 사이의 요소(각 요소는 1000이하 자연수)들의 합 출력하기 (x1 ≤ x2, y1 ≤ y2)
*
**** 1. 알고리즘 ****
* (x1,y1) 좌표에서 (x2,y2) 까지의 요소를 어떻게 가져오지?
* N*N 행렬은 최대 1,000,000(백만) 개 가능. M 은 십만인데 최악의 경우 십만번 질의 * 백만개 다 더하기 => 1억 훨씬 넘어. 그냥 더해선 안돼.
* 부분합 합배열 이용해야할듯.
* 백만개에 대해서 합배열 구해도 백만번 연산. 합배열 써도 되겠네.
*
* S[x2,y2] - S[x1-1, y1-1] 이 구하고자 하는 부분합.
* 그럼 n, m 차례로 입력받고,
* n*n 2차원 배열 입력받고,
* 배열 입력받음과 동시에 합배열 만들고,
* 질의 개수만큼 반복하면서 부분합 출력하자.
*
**** 2. 시간복잡도 ****
* O(N^2) 인가? n*n 2차원 배열이라.. 잘 모르겠네
*
**** 3. 자료구조 ****
* int[][] arr
*
**** 2차원배열 합배열 공식  ****
* S[x,y] 는 [1,1] 부터 [x,y] 까지 모든 요소들의 합을 의미
* -> S[x,y] = S[x-1, y] + S[x, y-1] - S[x-1, y-1] + Arr[x,y]
*
* Round(x1 y1 x2 y2) ->
* S[x2, y2]
* - S[x2, y1-1] (x2y2 와 같은 행의 다른 열)
* - S[x1-1, y2] (x2y2 와 같은 열의 다른 행)
* + S[x1-1, y1-1]
* */
/*
* 입력 예시
*   4 3
    ---
    1 2 3 4
    2 3 4 5
    3 4 5 6
    4 5 6 7
    -------
    2 2 3 4
    3 4 3 4
    1 1 4 4
* */
public class _3_PrefixSum_2 {

    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] sArr = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 읽는거 첫번째 for 문 안에 둬야
            for (int j = 1; j <= n; j++) {
                sArr[i][j] = sArr[i-1][j] + sArr[i][j-1] - sArr[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(sArr[x2][y2] - sArr[x1-1][y2] - sArr[x2][y1-1] + sArr[x1-1][y1-1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

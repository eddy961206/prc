package doit._1_dataStructure._1_arrayList;

import java.io.*;
import java.util.*;

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
        long[] count = new long[m]; // 합배열 S의 각 요소를 m으로 나눴을 때 나머지가 i 인 개수를 count[i]에 저장 (0<=i<m)

        // 나머지가 같은 시작 index들을 저장
        // key-나머지 , value-index의 리스트
        Map<Integer, List<Integer>> remainderIndices = new HashMap<>();
        for (int i = 0; i < m; i++) {
            remainderIndices.put(i, new ArrayList<>());
        }

        // 초기 상태 처리: S[0] = 0
        count[0]++;                        /////////////////     이해 안됨         ///////////////////////////
        remainderIndices.get(0).add(0);     /////////////////     이해 안됨         ///////////////////////////

        st = new StringTokenizer(br.readLine());
        // 누적합배열 S 만들기
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
            int remainder = (int) (S[i] % m);
            // Java에서 음수 나머지 처리
            if (remainder < 0) {
                remainder += m;
            }
            count[remainder]++;
            remainderIndices.get(remainder).add(i); // 나머지가 같은애들끼리 인덱스 추가
        }

        long result = 0;
        for (int i = 0; i < m; i++) {
            long cnt = count[i];
            result += (cnt * (cnt - 1)) / 2;
        }
        bw.write(result + "\n");

        // 구간 출력
//        for (int i = 0; i < m; i++) {
//            List<Integer> indices = remainderIndices.get(i);
//            if (i != 0) {   // S 요소가 m으로 나누어떨어지지 않을 때
//                for (int j = 0; j < indices.size(); j++) {
//                    for (int k = j + 1; k < indices.size(); k++) {
//                        bw.write((indices.get(j) + 1) + " " + (indices.get(k) + 1) + "\n");
//                    }
//                }
//
//            } else {    // 나누어떨어질 때
//                for (int j = 0; j < indices.size(); j++) {
//                    for (int k = j; k < indices.size(); k++) {
//                        bw.write((indices.get(j) + 1) + " " + (indices.get(k) + 1) + "\n");
//                    }
//                }
//
//            }
//
//        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        내풀이();
    }
}

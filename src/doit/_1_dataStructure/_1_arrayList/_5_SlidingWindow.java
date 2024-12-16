package doit._1_dataStructure._1_arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *
 * https://www.acmicpc.net/problem/12891
 *
 **** 0. 문제 정리 ****
 * 제한 : 2초, 512MB
 *
 **** 1. 알고리즘 ****
 * 슬라이딩 윈도우, 투포인터
 *
 **** 2. 시간복잡도 ****
 * S가 100만이라 O(N) 사용해야 (NlogN 은 2천만이라 가능은 함)
 *
 **** 3. 자료구조 ****
*/
/*
* 입력 예시
*   9 8
    CCTGGATTG
    2 0 1 1
* */
public class _5_SlidingWindow {
    static int[] myArr; // 현재 윈도우의 ACGT 개수 담는 배열
    static int[] checkArr; // 입력받은 최소 개수 규칙 배열 [A-0 C-1 G-2 T-1]
    static int checkSecret; // ACTG 중 몇개 알파벳이 조건에 만족하는지 개수. 4여야 다 만족.
    static void 답풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        myArr = new int[4];
        checkArr = new int[4];
        checkSecret = 0;
        char[] arr; // 입력받은 임의의 문자열

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++; // 조건에 0인거면 없어도 되니까 바로 조건만족 1 증가시킴
        }

        // 첫번째 윈도우 체크 (수동)
        for (int i = 0; i < p; i++) {
            Add(arr[i]);
        }

        if (checkSecret == 4) result++;

        // 반복 - 윈도우 슬라이딩하며 조건(checkArr) 에 맞는지 확인 - 맞으면 checkSecret++.
        for (int i = p; i < s; i++) {
            int j = i - p; // p 간격을 유지한채 이동.
            // 단 맨 끝에가서도 p간격 유지돼서 끝나야 하므로 끝 인덱스 기준으로 i(끝), i-p(시작) 로.
            // 간격이 p인 윈도우 => 끝인덱스(i) - 시작인덱스(i-p) = p
            // 즉 시작이 j, 끝이 i. 통상 의미의 반대가 됨
            Add(arr[i]); // 끝에건 새로 더하고
            Remove(arr[j]); // 시작은 빼고
            // 중간에 있던건 그대로 있음
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'B':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'C':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'D':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++; // >=이면 안됨. 개수 같아졌으면 그냥 그때만 '이제 조건 만족했네' 라고 1올리는게 다임.
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    static void 답풀이복습() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());


        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }

        for (int i = 0; i < p; i++) {
            Add2(arr[i]);
        }

        int result = 0;
        for (int i = p; i < s; i++) {
            int j = i - p;
            Add2(arr[i]);
            Remove2(arr[i]);
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
    }

    private static void Add2(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    private static void Remove2(char c) {
        switch (c) {
            case 'A' :
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'B':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'C':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'D':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        답풀이();
    }
}

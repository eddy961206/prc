package doit._1_dataStructure._1_arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/1940
*
**** 0. 문제 정리 ****
* 제한 : 2초, 256MB
*
**** 1. 알고리즘 ****
* N개의 고유한 10만 미만의 수 배열에서 두 개 요소의 합이 M 이 될 수 있는 경우의 수 구하기
* '고유한 수' 배열이라는게 힌트인듯. 첨에 a 가 있으면 M-a가 발견되는 즉시 cnt++ 하고 다음 반복으로 넘어가면 되겠군.
* 시작은 0번째 인덱스부터 끝인덱스를 M-a 가 발견될때까지.
* M-a 가 발견되면 시작인덱스를 ++, 끝 인덱스는 시작인덱스 +1부터 재시작.
* while ? for ? 둘다 상관없을 듯. while->끝인덱스가 [n-1] 이 아닌 동안. for 면 2중for문 break 사용..
* 아니다 이건 배열의 순서가 오름차순이 아니라서 while 써서 시작/끝 인덱스 특정 조건에 맞게 움직이면 안됨.
* 처음부터 순서대로 인덱스가 차례로 움직여야해서 2중 for문을 써야겠군.
* i < j
*
* 위 설명 for 문 쓰면 안됨.
* 일단 두 요소간의 크기비교(n과 같은지)니까 정렬을 하면 좋음.
* 보통 정렬 시간 복잡도 nlogn. 충분히 가능 => 10만단위
* 정렬 후 양 끝에 비교 <- 그냥 문제 많이 풀어봐야 왜 이렇게 하는지 감이 온다고 함
*
*
**** 2. 시간복잡도 ****
* 2중for문 ->  O(N^2) => 10만의 제곱이면 1억 훨씬 넘음.. 근데 제출해보니 236ms 밖에 안걸렸네?? N이 다 작은수로만 채점됐나보다..
**** 3. 자료구조 ****
*
/*
* 입력 예시
*   6
    9
    2 7 4 1 5 3
* */
public class _4_TwoPointer_2 {

    static void 내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == m) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }

    static void 답힌트보고내풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 숫자 1개 받으니까 st 안쓰고 br.readLine() 바로씀
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int cnt = 0;
        while (start < end) {
            if (arr[start] + arr[end] < m) start++;
            else if (arr[start] + arr[end] > m) end--;
            else {cnt++; start++; end--;}
        }
        System.out.println(cnt);
    }
    


    public static void main(String[] args) throws IOException {
//        내풀이();
        답힌트보고내풀이();
    }
}

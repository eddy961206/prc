package doit._1_dataStructure._1_arrayList;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11659
* https://www.youtube.com/watch?v=JSfXW7UJ04Y&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=3&ab_channel=%ED%95%98%EB%A3%A8%EC%BD%94%EB%94%A9
*
* 1. 아이디어
* - 입력
* 1번째 줄 : 배열 요소 개수(N) 과 구간합 구하기 몇번 반복해야하는지(M-질의개수), 1<=N,M<=100,000
* 2번째 줄 : N 개의 수 배열. 1<=수<=1000
* 3번째 줄 ~ 3+(M-1)번째 줄: i j (1<=i<=j<=N)
*
* - 출력
* M개의 i~j 번째 수의 합
*
* N을 반복문으로 nextInt를 통해 받아서 int[] 에 넣을수도 있어.
* 하지만 연습삼아 stream을 사용하기 위해 nextLine을 통해 String 으로 한꺼번에 받아서 int 로 변환해보자.
* 스트림은 데이터양이 많으면 느리니까 코테에서 잘은 안쓰인다고 하는군.

* 이건 N개의 수 배열을 입력받으면 반드시 배열에 저장해놔야 해.
* i~j 사이 인덱스인 요소들의 합을 구해야 하는데 일회성으로 temp로 받고 처리할 수가 없으니까 말이야.
* 그럼 반복문 돌기 전에 int[] 을 선언/초기화 해야겠군.
*
* int[] 에 넣고 나서 어떻게 i,j 사이의 합을 구하지?
* A[i] ~ A[j] 의 합은 S[j] - S[i-1] 과 같아. 즉 S 합배열을 먼저 구해야해
* 합배열은 어떻게 구하지?
* S[1] = A[1], S[2] = A[1] + A[2], S[3] = A[1] + A[2] + A[3],... 이야.
* 즉 S[i] = S[i-1] + A[i]야. 다만 i 는 1보다 커야하고 S[0] = A[0] 이야.
* 그럼 첫 요소부터 다음요소 누적하면 되겠군.
*
* i, j 는 M번 반복하며 nextInt 로 받자. 처음에 미리 받아서 다 저장을 해놔야하나?
* 아님 미리 합배열 만들어놓고 그때그때 받은 i,j 로 답 바로바로 출력하나?
* 후자가 더 나은 듯.
*
* 2. 시간 복잡도 : 각 요소를 다 도니까 for 문 1개면 돼. O(N) 이겠군
*
* 3. 자료구조 :
* 배열 []
*
* 새로 배운것 :
* 0. 10만개 입력 너무많기 때문에 Scanner 말고 BufferedReader 사용.
* 1. 10만개 숫자 배열을 한줄에 쭉 들어오는거 int로 받기 힘듦 -> StringTokenizer 로 분리해서
* 1. 원본배열이 변하지 않기 때문에 합배열 쓸 수 있는것.
* 2. 합배열 모른다고 가정. 그냥 해당 구간 일일이 다 더한다고 할 때 최악의 케이스는
* 1번째~10만번째(N=10만,i=1,j=10만) 까지 다 더하는걸 10만번(M) 반복해야함 -> 10만*10만 -> 1억 넘어서 1초넘게 걸려서 안돼
* 다른방법을 찾아야함 -> '합배멸 써야겠구나' 이런식으로 생각해야
* 3. int[] 에 큰 값이 더해져서 들어올거 같으면 그냥 처음부터 long[] 으로 써.
* 4. BufferedReader, BufferedWriter 사용해야 빠름
*
* */
public class _3_PrefixSum {

    static void 내풀이(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // \n 줄바꿈 버퍼 비우기
        String sArr = sc.nextLine();

        int[] arr = Arrays.stream(sArr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 합배열 만들기
        int[] prefixSumArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefixSumArr[i] = sum;
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;

            int prefixSum;
            if (i == 0) {
                prefixSum = prefixSumArr[j];
            } else {
                prefixSum = prefixSumArr[j] - prefixSumArr[i-1];
            }
            System.out.println(prefixSum);
        }

    }

    static void 내풀이2(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] prefixArr = new int[n];
        prefixArr[0] = sc.nextInt();
        for (int i = 0; i < n+1; i++) {
            prefixArr[i+1] = prefixArr[i] + sc.nextInt();
        }

    }

    static void 답풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // readLine -> 첫번째 줄 읽어왔다는 뜻

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 받으면서 바로 합배열 만들기위해 합배열 초기화
        long[] S = new long[n + 1]; // 기본으로 0으로 배열이 다 차있음
        // 숫자형데이터 다룰 때 int 벗어날까봐 습관적으로 long 으로 선언하는게 좋음
        // n+1 로 한건 0번째 신경 안쓰려고

        // 배열 받아오면서 바로 합배열 만듦
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
        // i 가 1부터 시작하는 이유 : S[i-1] 에러 안나게.
        // i가 n까지 포함인 이유 : i 가 1부터 시작인데 총 n 번 반복해야하니까.
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        // 구간합 출력 (반복회수 : m번)
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }


    }

    static void 답풀이복습() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];

        // 새로운 입력받은 줄 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }
    }

    static void 답풀이복습2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i - 1]);

        }

    }

    static void 다른사람풀이_bufferedWriter() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write(S[j] - S[i - 1] + "\n");
        }

        bw.flush();
        bw.close(); // bw.close 해도 flush 자동으로 됨
        br.close();


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

//        내풀이2(sc);
        내풀이(sc);
//        답풀이();

        sc.close();
    }
}

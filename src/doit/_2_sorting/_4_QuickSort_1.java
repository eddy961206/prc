package doit._2_sorting;

import java.io.*;
import java.util.StringTokenizer;

/*
 *
 * https://www.acmicpc.net/problem/11004
 *
 **** 0. 문제 정리 ****
 * 제한 : 2초, 512MB
 * 1 <= N <= 5백만, 1 <= K <= N
 **** 1. 알고리즘 ****
 *  퀵정렬
 * 오름차순 정렬 후 K번째 있는 수만 구하면 되니 K 번째 이전/이후는 정렬 필요 없을수도 있어서 퀵정렬 사용
 *
 **** 2. 시간복잡도 ****
 * 평균 : N*logN, 최악 : O(N2)
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
* */
public class _4_QuickSort_1 {

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static class 답풀이 {
        private static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 퀵소트 수행
            quickSort(A, 0, N - 1, K - 1);

            // K번째 수 출력
            System.out.println(A[K - 1]);
        }

        static void quickSort(int[] A, int S, int E, int K) {
            if (S >= E) return; // 정렬할 범위가 1개 이하면 종료

            int pivotIdx = partition(A, S, E);

            if (pivotIdx == K) {
                return;
            } else if (K < pivotIdx) {
                // K 가 pivot 보다 작으면 왼쪽 파티션만 정렬
                quickSort(A, S, pivotIdx - 1, K);
            } else {
                // K가 pivot 보다 크면 오른쪽 파티션만 정렬
                quickSort(A, pivotIdx + 1, E, K);
            }
        }

        static int partition(int[] A, int S, int E) {
            if (S + 1 == E) {
                // 두 개만 남았을 때 처리
                if (A[S] > A[E]) swap(A, S, E);
                return E;
            }

            int M = (S + E) / 2;
            swap(A, S, M); // 중앙값을 첫 번째 요소로 이동
            int pivot = A[S]; // 아까 그 중앙값(이젠 첫번째 요소)을 pivot 으로 지정
            int start = S + 1, end = E;

            while (start <= end) { // -> end 가 start 보다도 더 작아졌을 때(역전) 빠져나가서 이후 로직 실행되게끔
                while (end >= S + 1 && A[end] > pivot) end--;   // 피벗보다 작은 값 찾아가기
                while (start <= E && A[start] < pivot) start++; // 피벗보다 큰 값 찾아가기

                if (start < end) {
                    swap(A, start++, end--); // start와 end 자리 교환 후 포인터 이동
                } else {
                    break;
                }
            }

            // 피벗 값을 제 위치로 이동
            A[S] = A[end];
            A[end] = pivot;
            return end;
        }


    }

    private static class 내풀이 {
        private static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            quickSort(A, 0, N - 1, K - 1);

            System.out.println(A[K - 1]);
        }

        static void quickSort(int[] A, int start, int end, int K) {
            int part2Start = partition(A, start, end, K);

            if (part2Start == K) {
                return;
            } else if (K < part2Start) {
                // 왼쪽 파티션 퀵정렬
                if (start + 1 < part2Start) quickSort(A, start, part2Start - 1, K);
            } else {
                // 오른쪽 파티션 퀵정렬
                if (part2Start < end) quickSort(A, part2Start, end, K);
            }
        }

        static int partition(int[] A, int S, int E, int K) {
            int pivot = A[(S + E) / 2];
            while (S <= E) {
                while (A[S] < pivot) S++;
                while (A[E] > pivot) E--;
                if (S <= E) {
                    swap(A, S++, E--);
                }
            }
            return S;
        }

        static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
//        답풀이.main();
        내풀이.main();
    }
}

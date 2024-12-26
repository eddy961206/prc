package doit._1_dataStructure._1_arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 *
 * https://www.acmicpc.net/problem/11286
 *
 **** 0. 문제 정리 ****
 * 제한 : 2초, 256MB
 * 1 <= N <= 10만, -2의31승 < X < 2의 31승 => int 범위
 **** 1. 알고리즘 ****
 * <--- N번 반복
 * 입력받은 숫자들을 배열에 차례로 저장 (0이 아닌 동안)
 * 0이면 현재 배열에서 절댓값 가장 작은 애 출력 후 걔는 제거, 배열 비어있으면 0 출력.
 * 0일시 현재 배열에서 절댓값 가장 작은 애가 여러개면 그 중 작은 애 출력후 제거.
 * --->
 * 우선순위 큐 사용해야
 *
 **** 2. 시간복잡도 ****
 *
 *
 *
 **** 3. 자료구조 ****
 * 왜 우선순위 큐?
 */
/*
* 입력 예시
* */
public class _7_Queue_2 {
    static void 답풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {  // 절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs;  // 절댓값 작은 데이터 우선 정렬 (오름차순)
        }));

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }

    static void 답풀이연습() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>((o1, o2) -> {
            int o1_abs = Math.abs(o1);
            int o2_abs = Math.abs(o2);

            // 절댓값 작은거부터 (오름차순)
            // 절댓값 같으면 음수인 애
            if (o1_abs == o2_abs) {
                return o1 > o2 ? 1 : -1;
            }

            return o1_abs - o2_abs;
        });

        for (int i = 0; i < N; i++) {
            int req = Integer.parseInt(br.readLine());
            if (req == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(req);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        답풀이();
    }
}

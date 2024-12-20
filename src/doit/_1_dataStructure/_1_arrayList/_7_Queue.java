package doit._1_dataStructure._1_arrayList;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *
 * https://www.acmicpc.net/problem/2164
 *
 **** 0. 문제 정리 ****
 * 제한 : 2초, 128MB
 *
 **** 1. 알고리즘 ****
 * 큐
 * 1~N 까지 반복문으로 큐에 저장
 * <--- 반복
 * 큐에 넣었던 순서대로 pop 하나 하고
 * 남아있는 큐의 가장 오래된 애(가장 작은 애) 를 맨 아래로 옮기기
 * 맨 아래로 옮기는건 어떻게 하지??
 * ---> 큐에 하나 남을 때까지
 *
 **** 2. 시간복잡도 ****
 * 1 ≤ N ≤ 500,000
 * while
 * O(N)
 **** 3. 자료구조 ****
 * 양쪽에서 삭제/삽입 일어남 -> 큐
 */
/*
* 입력 예시
*   6
* */
public class _7_Queue {
    static void 답풀이() throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }

        System.out.println(myQueue.poll());
    }

    static void 답풀이복습() throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }


    public static void main(String[] args) throws IOException {
        답풀이();
    }
}

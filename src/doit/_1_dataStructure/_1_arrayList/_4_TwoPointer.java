package doit._1_dataStructure._1_arrayList;

import java.util.*;

/*
* https://www.acmicpc.net/problem/2018
*
**** 0. 문제 정리 ****
* 제한 : 2초, 256MB
*
**** 1. 알고리즘 ****
* 1부터 n 까지 연속된 배열에서 연속된 요소들의 부분합이 n 과 같아지는 경우의 수 구하기
*
**** 2. 시간복잡도 ****
* n 은 최대 천만.
* 최대 2n-2 번 반복 -> O(N)
**** 3. 자료구조 ****
*
/*
* 입력 예시
*   15
* */
public class _4_TwoPointer {

    static void 내풀이() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        // end 가 n 이면 가능한 유일한 경우는 start 도 n 이어야.
        // 하지만 그 경우는 첨에 count 를 1로 초기화해서 미리 고려해놨기 때문에 end가 n인 경우까지는 가지 않음.
        while (end != n) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                ++start;
            } else if (sum == n) {
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);

        sc.close();

    }

    static void 내풀이복습(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 1;
        int cnt = 1;
        int start = 1;
        int end = 1;
        while (end != n) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                cnt++;
                end++;
                sum += end;
            }
        }
        System.out.println(cnt);
        sc.close();
    }


    public static void main(String[] args) {
        내풀이();
    }
}

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


    public static void main(String[] args) {
        내풀이();
    }
}

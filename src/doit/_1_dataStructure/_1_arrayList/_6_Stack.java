package doit._1_dataStructure._1_arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 *
 * https://www.acmicpc.net/problem/1874
 *
 **** 0. 문제 정리 ****
 * 제한 : 2초, 512MB
 *
 **** 1. 알고리즘 ****
 * 스택
 *
 **** 2. 시간복잡도 ****
 * O(N)
 *
 **** 3. 자료구조 ****
 */
/*
* 입력 예시
*   5
    1
    2
    5
    3
    4
* */
public class _6_Stack {
    static void 답풀이() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int su = arr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);

    }

    static void 답풀이복습() throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int su = arr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);
    }

    static void 답풀이복습2() throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int su = arr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);

    }

    static void 답풀이복습_프린트() throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();

        for (int i = 0; i < N; i++) {
            int su = arr[i];
            System.out.println("\n현재 찾는 수: " + su + " (arr[" + i + "])");            System.out.println("현재 num 값: " + num);

            if (su >= num) {
                while (su >= num) {
                    stack.push(num);
                    System.out.println("스택에 " + num + " 추가됨");
                    System.out.println("현재 스택 상태: " + stack);
                    bf.append("+\n");
                    num++;
                }
                int poppedNum = stack.pop();
                System.out.println(poppedNum + " 이(가) 스택에서 제거됨");
                System.out.println("현재 스택 상태: " + stack);
                bf.append("-\n");
            } else {
                int n = stack.pop();
                System.out.println(n + " 이(가) 스택에서 제거됨");
                System.out.println("현재 스택 상태: " + stack);
                if (n > su) {
                    System.out.println("NO - 수열을 만들 수 없음");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if (result) System.out.println(bf);
    }

    static void 답풀이복습4() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int su = arr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);
    }

    static void 답풀이복습5() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        int ascNum = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            if (target >= ascNum) {
                while (target >= ascNum) {
                    stack.push(ascNum++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if (n > target) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) System.out.println(sb);


    }




    public static void main(String[] args) throws IOException {
//        답풀이복습();
        답풀이복습_프린트();
//        답풀이();
    }
}

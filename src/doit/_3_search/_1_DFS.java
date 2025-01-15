package doit._3_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *
 * https://www.acmicpc.net/problem/11724
 *
 **** 0. 문제 정리 ****
 * 제한 : 3초, 512MB
 *
 **** 1. 알고리즘 ****
 * DFS
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
 * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
 * (1 ≤ u, v ≤ N, u ≠ v)
 *
 **** 2. 시간복잡도 ****
 * 1 ≤ N ≤ 1,000
 * O(N^2) -> 백만
 **** 3. 자료구조 ****
 * stack
 */
/*
* 입력 예시
*   6
* */
public class _1_DFS {
    private static class 답풀이 {
        static ArrayList<Integer>[] A;
        static boolean visited[];

        static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n + 1];   // 0번 인덱스 사용 안하려고. 1부터 시작해야
            A = new ArrayList[n + 1];       // 0번 인덱스 사용 안하려고. 1부터 시작해야

            for (int i = 1; i <= n; i++) {  // 1부터 시작
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {  // 1부터 시작
                if (!visited[i]) {
                    cnt++;
                    DFS(i);
                }
            }

            System.out.println(cnt);
        }

        static void DFS(int v) {
            if (visited[v]) return;
            visited[v] = true;
            for (int i : A[v]) {
                if (!visited[i]) {
                    DFS(i);
                }
            }
        }
    }
    private static class 복습1 {
        static ArrayList<Integer>[] A;
        static boolean[] visited;

        static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            A = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[e].add(s);
                A[s].add(e);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cnt++;
                    DFS(i);
                }
            }
            System.out.println(cnt);
        }

        static void DFS(int v) {
            if (visited[v]) return;
            visited[v] = true;
            for (int i : A[v]) {
                if (!visited[i]) {
                    DFS(i);
                }
            }
        }

    }
    private static class 복습2 {
        static ArrayList<Integer>[] A;
        static boolean[] visited;

        static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            A = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(e);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cnt++;
                    DFS(i);
                }
            }
            System.out.println(cnt);
        }

        static void DFS(int v) {
            if (visited[v]) return;
            visited[v] = true;
            for (int i : A[v]) {
                if (!visited[i]) {
                    DFS(i);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
//        답풀이.main();
        복습1.main();
    }

}

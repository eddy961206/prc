package doit._3_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *
 * https://www.acmicpc.net/problem/11724
 *
 **** 0. 문제 정리 ****
 *  1 초	192 MB
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
 * 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
 * 각각의 수들은 붙어서 입력으로 주어진다.
 *
 **** 1. 알고리즘 ****
 * BFS
 *
 **** 2. 시간복잡도 ****
 *
 *
 **** 3. 자료구조 ****
 *
 */
/*
* 입력 예시
*   6
* */
public class _2_BFS {
    private static class 답풀이 {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};
        static boolean[][] visited;
        static int[][] A;
        static int N, M;
        static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(line.substring(j, j + 1));
                }
            }

            BFS(0, 0);
            System.out.println(A[N - 1][M - 1]);
        }

        private static void BFS(int i, int j) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {i, j});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int k = 0; k < 4; k++) { // 상하좌우로 탐색
                    int x = now[0] + dx[k];
                    int y = now[1] + dy[k];
                    if (x >= 0 && y >= 0 && x < N && y < M) { //   배열을 넘어가면 안되고
                        if (A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈 수 없거나 방문한 곳이면 안됨
                            visited[x][y] = true;
                            A[x][y] = A[now[0]][now[1]] + 1;  // 핵심. depth + 1
                            queue.add(new int[] {x, y});
                        }
                    }
                }
            }
        }
    }

    private static class 복습1 {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};
        static boolean[][] visited;
        static int[][] A;
        static int N, M;
        static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            A = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(line.substring(j, j + 1));
                }
            }

            BFS(0, 0);
            System.out.println(A[N - 1][M - 1]);
        }

        static void BFS(int i, int j) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, j});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = now[0] + dx[k];
                    int y = now[1] + dy[k];
                    if (x >= 0 && y >= 0 && x < N && y < M) {
                        if (A[x][y] != 0 && !visited[x][y]) {
                            visited[x][y] = true;
                            A[x][y] = A[now[0]][now[1]] + 1;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        답풀이.main();
    }

}

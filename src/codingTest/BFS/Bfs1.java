package codingTest.BFS;



/*
*
* 1. 아이디어
* - 2중 for문 => 값이 1 && 이전 방문X => BFS
* - BFS 돌면서 그림 개수++, 최대그림넓이 값 갱신
*
* 2. 시간복잡도
* - BFS : O(V+E)
* - V = m * n (500 * 500)
* - E = 1개 vertex 당 최대 4개 연결 있으므로 넉넉잡아 4V = 4*m*n
*
* - V : 500 * 500
* - E : 4 * 500 * 500
* - V + E : 5 * 500 * 500 = 1,250,000 < 21억 미만 (int)
*
* 3. 자료구조
* - 그래프 전체 지도 : int[][]
* - 방문 : bool[][]
* - Queue(BFS)
*
* */


import java.util.Arrays;
import java.util.Scanner;

public class Bfs1 {
    static int n, m;
    static int[][] map;
    static boolean[][] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        // 입력값으로 map 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }



    }

}

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


public class Bfs1 {
    public static void main(String[] args) {


    }

    public static void result(int m, int n, int[][] map) {


    }
}

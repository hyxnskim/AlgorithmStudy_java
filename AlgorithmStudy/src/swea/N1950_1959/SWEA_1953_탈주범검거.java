package swea.N1950_1959;

/**
 * <pre>
 * My solution for SWEA_1953
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {

	static int N, M, L;	// 지도의 세로/ 가로 크기, 탈출 후 소요시간
	static int[][] mat;
	static boolean[][] isVisited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] pipes = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			mat = new int[N][M];
			isVisited = new boolean[N][M];
			
			Pos start = new Pos(sc.nextInt(), sc.nextInt(), 1);
			L = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			System.out.printf("#%d %d\n", t+1, bfs(start));
		}
		
		sc.close();
	}
	
	static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= M || mat[x][y] == 0);
	}
	
	static int bfs(Pos pos) {
		Queue<Pos> queue = new LinkedList<>();
		int cnt = 1;
		
		queue.offer(pos);
		isVisited[pos.x][pos.y] = true;
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			if(now.depth >= L) break;
			int x = now.x; int y = now.y;
			
			int pipe = mat[x][y];
			int dir, xx, yy;
			for(int j = 0; j < pipes[pipe].length; j++) {
				dir = pipes[pipe][j];
				xx = x + dx[dir]; yy = y + dy[dir];
				
				if(isWall(xx, yy) || isVisited[xx][yy]) continue;
				
				boolean flag = false;
				int nextPipe = mat[xx][yy], nextDir;
				for(int k = 0; k < pipes[nextPipe].length; k++) {
					nextDir = pipes[nextPipe][k];
					if((dir == 0 && nextDir == 1) || (dir == 1 && nextDir == 0)
							|| (dir == 2 && nextDir == 3) || (dir == 3 && nextDir == 2)){
						flag = true;
						break;
					}
				}
				
				if(flag) {
					//System.out.println("(" + xx + ", " + yy + ")");
					queue.offer(new Pos(xx, yy, now.depth+1));
					isVisited[xx][yy] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

}

class Pos{
	int x, y, depth;
	Pos(int x, int y, int depth){
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
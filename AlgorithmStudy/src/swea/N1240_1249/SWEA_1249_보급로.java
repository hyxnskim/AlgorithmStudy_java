package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1249
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[][] mat;
	static int[][] ans;
	static boolean[][] isVisited;
	static int res;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			mat = new int[N][N];
			ans = new int[N][N];
			isVisited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String tmp = sc.next();
				for(int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(tmp.charAt(j) + "");
				}
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;
			
			res = Integer.MAX_VALUE;
			isVisited[0][0] = true;
			bfs(0, 0);
			
			System.out.printf("#%d %d\n", t+1, res);
		}
		sc.close();
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
	
	public static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		
		queue.offer(new Position(x, y));
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Position pos = queue.poll();
			int nowx = pos.x;
			int nowy = pos.y;
			
			if(nowx == N-1 && nowy == N-1) {
				if(res > ans[N-1][N-1]) res = ans[N-1][N-1];
			}
			if(ans[nowx][nowy] > res) continue;
			
			int xx, yy;
			for(int i = 0; i < 4; i++) {
				xx = nowx + dx[i]; yy = nowy + dy[i];
									// 아직 방문전인 노드이거나         이미 다른 경로로 방문했지만, 현 경로보다 복구시간이 긴 경로일 경우
				if(!isWall(xx, yy) && (!isVisited[xx][yy] || ans[xx][yy] > ans[nowx][nowy] + mat[xx][yy])) {
					isVisited[xx][yy] = true;
					ans[xx][yy] = ans[nowx][nowy] + mat[xx][yy];
					queue.offer(new Position(xx, yy));
				}
			}
		}
	}
}

class Position{
	int x, y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}


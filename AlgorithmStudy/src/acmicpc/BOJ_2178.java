package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2178 {
	
	static int N, M;
	static int[][] mat;
	static boolean[][] isVisited;
	static int min;
	static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		isVisited = new boolean[N][M];
		min = N * M;
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				mat[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		isVisited[0][0] = true;
		search(0, 0);
		
		System.out.println(mat[N-1][M-1]);
		
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= M);
	}
	
	public static void search(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = cur[0] + dx[i];
				int yy = cur[1] + dy[i];
				
				if(!isWall(xx, yy) && !isVisited[xx][yy] && mat[xx][yy] > 0) {
					queue.add(new int[] {xx, yy});
					mat[xx][yy] = mat[cur[0]][cur[1]] + 1;
					isVisited[xx][yy] = true;
				}
			}
			
		}		
	}

}

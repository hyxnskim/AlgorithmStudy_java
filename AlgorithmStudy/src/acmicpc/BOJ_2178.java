package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

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
		search(0, 0, 1);
		
		System.out.println(min);
		
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= M);
	}
	
	public static void search(int x, int y, int cnt) {
		if(x == N-1 && y == M-1) {
			if(cnt < min) min = cnt;
			return;
		}
		if(cnt > min) return;
		
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(!isWall(xx, yy) && !isVisited[xx][yy] && mat[xx][yy] == 1) {
				isVisited[xx][yy] = true;
				search(xx, yy, cnt+1);
				isVisited[xx][yy] = false;
			}
		}
	}

}

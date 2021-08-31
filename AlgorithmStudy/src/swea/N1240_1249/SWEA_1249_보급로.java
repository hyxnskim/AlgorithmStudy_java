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


import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[][] mat;
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
			isVisited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String tmp = sc.next();
				for(int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(tmp.charAt(j) + "");
				}
			}
			
			res = 0;
			isVisited[0][0] = true;
			dfs(0, 0, 0, isVisited);
			
			System.out.printf("#%d %d\n", t+1, res);
		}
		sc.close();
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
	
	public static void dfs(int x, int y, int distance, boolean[][] isVisited) {
		
		//System.out.println("x = " + x + " y = " + y);
		
		distance += mat[x][y];
		if(res != 0 && distance > res) return;
		
		int xx , yy;
		for(int i = 0; i < 4; i++) {
			xx = x + dx[i]; yy = y + dy[i];
			if(!isWall(xx, yy) && !isVisited[xx][yy]) {
				boolean[][] newVisited = copy(isVisited);
				newVisited[xx][yy] = true;
				dfs(xx, yy, distance, newVisited);
			}
			if(xx == N-1 && yy == N-1) {
				//System.out.println(distance);
				if(res == 0 || res > distance) res = distance;
				return;
			}
		}
		
	}
	
	public static boolean[][] copy(boolean[][] isVisited){
		boolean[][] list = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				list[i][j] = isVisited[i][j];
			}
		}
		return list;
	}
}

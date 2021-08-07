package swea.N1940_1949;

/**
 * <pre>
 * My solution for SWEA_1949
 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq&categoryId=AV5PoOKKAPIDFAUq&categoryType=CODE&problemTitle=1949&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1949_등산로조성 {
	public static int S, K;
	public static int len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			S = sc.nextInt();
			K = sc.nextInt();
			
			int[][] map = new int[S][S];
			int max = 0;
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					int tmp = sc.nextInt();
					map[i][j] = tmp;
					if(tmp > max) max = tmp;
				}
			}
			
			len = 0;
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					if(map[i][j] == max) {
						int[][] tempMap = copy(map);
						dfs(tempMap, i, j, 1, false);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t+1, len);
		}
		
		sc.close();
	}
	
	public static void dfs(int[][] map, int x, int y, int depth, boolean isUsed) {
		
		if(depth > len) len = depth;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] tmap;
		
		int xx, yy;
		for(int i = 0; i < 4; i++) {
			xx = x + dx[i];
			yy = y + dy[i];
			
			if(isWall(xx, yy)) continue;
			
			if(map[xx][yy] < map[x][y]) {
				tmap = copy(map);
				tmap[x][y] = 100;
				dfs(tmap, xx, yy, depth + 1, isUsed);
				
			} else if(!isUsed) {
				for(int k = 1; k <= K; k++) {
					if(map[xx][yy] - k < map[x][y]) {
						tmap = copy(map);
						tmap[x][y] = 100;
						tmap[xx][yy] -= k;
						dfs(tmap, xx, yy, depth + 1, true);
					}
				}
			}
		}
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= S || y < 0 || y >= S);
	}
	
	public static int[][] copy(int[][] original){
		int[][] arr = new int[S][S];
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				arr[i][j] = original[i][j];
			}
		}
		return arr;
	}
}

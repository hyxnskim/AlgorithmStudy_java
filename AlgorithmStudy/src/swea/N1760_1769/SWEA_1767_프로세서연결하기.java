package swea.N1760_1769;

/**
 * <pre>
 * My solution for SWEA_1767
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1767_프로세서연결하기 {

	static int N;
	static int[][] mat;
	static int cnt_max, min;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			mat = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			cnt_max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			solution(mat, 0, 0, 0, 0);
			System.out.printf("#%d %d\n", t+1, min);
		}
		
		sc.close();
	}
	
	static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
	
	static void mark(boolean isPos, int[][] arr, int x, int xx, int y, int yy) {
		int m = isPos ? -1 : 0;
		
		if(y == yy) {
			if(x < xx) for(int i = x+1; i < xx; i++) arr[i][y] = m;
			else for(int i = x-1; i > xx; i--) arr[i][y] = m;
		} else {
			if(y < yy) for(int i = y+1; i < yy; i++) arr[x][i] = m;
			else for(int i = y-1; i > yy; i--) arr[x][i] = m;
		}
	}
	
	static void solution(int[][] arr, int x, int y, int cnt, int len) {
		
		for(int i = x; i < N; i++) {
			int j = (i == x ? y : 0);
			for(; j < N; j++) {
				
				if(i == N-1 && j == N-1) {
					if(mat[i][j] == 1) cnt++;
					if(cnt > cnt_max) {
						cnt_max = cnt; min = len;
					}
					if(cnt >= cnt_max && len < min) min = len;
					return;
				}
				
				if(mat[i][j] == 1) {
					if(i == 0 || i == N-1 || j == 0 || j == N-1) {
						cnt++;
						continue;
					}
					
					for(int dir = 0; dir < 4; dir++) {
						int xx = i + dx[dir];
						int yy = j + dy[dir];
						
						boolean flag = false;
						while(!isWall(xx, yy)) {
							if(arr[xx][yy] != 0) {
								flag = true; break;
							}
							xx += dx[dir]; yy += dy[dir];
						}
						
						if(!flag) {
							mark(true, arr, i, xx, j, yy);
							
							int nexti = i; int nextj = j+1;
							if(j == N-1) {
								nextj = 0;
								nexti = i+1;
							}
							
							solution(arr, nexti, nextj, cnt+1, len + Math.abs(xx - i) + Math.abs(yy - j) - 1);
							mark(false, arr, i, xx, j, yy);
						}
					}
				}
			}
		}
	}
}

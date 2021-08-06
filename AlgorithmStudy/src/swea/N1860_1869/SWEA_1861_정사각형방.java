package swea.N1860_1869;

/**
 * <pre>
 * My solution for SWEA_1861
 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=1861&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1861_정사각형방 {
	
	public static int S;
	public static int[][] map;
	public static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			S = sc.nextInt();
			map = new int[S][S];
			count = new int[S * S + 1];
			
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					solution(i, j);
				}
			}
			
			int max = 0;
			for(int i = 1; i < count.length; i++) {
				if(count[i] > count[max]) max = i;
			}
			
			System.out.printf("#%d %d %d\n", t+1, max, count[max]);
		}
		sc.close();
	}
	
	public static void solution(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int curx = x, cury = y;
		int xx, yy;
		int cnt = 1;
		while(true) {
			int i = 0;
			for(; i < 4; i++) {
				xx = curx + dx[i];
				yy = cury + dy[i];
				
				if(!isWall(xx, yy) && map[xx][yy] == map[curx][cury] + 1) {
					curx = xx; cury = yy;
					break;
				}
			}
			
			if(i == 4) break;
			cnt++;
		}
		count[map[x][y]] = cnt;
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= S || y < 0 || y >= S);
	}
}

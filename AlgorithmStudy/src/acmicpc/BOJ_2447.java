/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2447
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2447 {
	
	static int N;
	static boolean[][] mat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		mat = new boolean[N][N];
		star(0, 0, N);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(mat[i][j]) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		sc.close();
	}
	
	static void star(int x, int y, int n) {
		if(n < 3) return;
		if(n == 3) draw(x, y);
		
		int limit = (n/3)*2+x;
		
		for(int i = x; i < x+n; i++) {
			for(int j = y; j < y+n; j++) {
				if(i >= x+n/3 && i < limit && j == y + n/3) {
					j += n/3;
				}
				if(i % (n/3) == 0 && j % (n/3) == 0) star(i, j, n/3);
			}
		}
	}
	
	static void draw(int x, int y) {
		for(int i = 0; i < 3; i++) {
			mat[x][y+i] = true;
			mat[x+2][y+i] = true;
		}
		
		mat[x+1][y] = true;
		mat[x+1][y+2] = true;
	} // end of draw
}

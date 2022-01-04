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
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(mat[i][j]) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		
		
		sc.close();
	}
	
	static void star(int x, int y, int n) {
		if(n < 3) return;
		if(n == 3) draw(x, y);
		
		int limit = (x+n/3)*2;
		if(limit > N) limit = N-n/3;
		
		for(int i = x; i < x+n; i++) {
			for(int j = y; j < y+n; j++) {
				if(mat[i][j]) continue;
				if(i >= x+n/3 && i < limit && j == y + n/3) {
					j += n/3;
				}
				if(i % (n/3) == 0 && j % (n/3) == 0) star(i, j, n/3);
			}
		}
	}
	
	static void draw(int x, int y) {
		for(int i = x; i < x+3; i++) {
			if(i == x || i == x+2) {
				for(int j = y; j < y+3; j++) {
					mat[i][j] = true;
				}
			} else {
				mat[i][y] = true;
				mat[i][y+2] = true;
			}
		}
	} // end of draw

}

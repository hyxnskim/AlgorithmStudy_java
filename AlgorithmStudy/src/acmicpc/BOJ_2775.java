package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2775
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2775 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[15][15];
		for(int i = 0; i < 15; i++) {
			arr[0][i] = i;
			arr[i][0] = 0;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(arr[k][n]);
		}
		
		sc.close();
	}

}

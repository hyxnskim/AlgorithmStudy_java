package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/3009
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_3009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int[][] arr = new int[3][2];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		boolean[] findX = new boolean[3];
		boolean[] findY = new boolean[3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == j) continue;
				if(arr[i][0] == arr[j][0]) {
					findX[i] = true;
					findX[j] = true;
				}
				if(arr[i][1] == arr[j][1]) {
					findY[i] = true;
					findY[j] = true;
				}
			}
		}
		
		int x = 0, y = 0;
		for(int i = 0; i < 3; i++) {
			if(!findX[i]) x = arr[i][0];
			if(!findY[i]) y = arr[i][1];
		}
		
		System.out.println(x + " " + y);
				
		sc.close();
	}

}

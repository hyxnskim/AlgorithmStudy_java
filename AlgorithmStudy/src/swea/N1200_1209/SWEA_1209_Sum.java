package swea.N1200_1209;

import java.util.Scanner;

public class SWEA_1209_Sum {
	
	/**
	 * <pre>
	 * My solution for SWEA_1209
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=1209&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			int[][] arr = new int[100][100];
			int max = 0;
			sc.nextInt();
			
			// 입력
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 100; i++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int j = 0; j < 100; j++) {
					sum1 += arr[i][j];	// 가로합
					sum2 += arr[j][i];	// 세로합
				}
				if(sum1 > max) max = sum1;
				if(sum2 > max) max = sum2;
			}
			
			// 대각선합
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < 100; i++) {
				sum1 += arr[i][i];
				sum2 += arr[i][100-i-1];
			}
			if(sum1 > max) max = sum1;
			if(sum2 > max) max = sum2;
			
			res[t] = max;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		sc.close();
	}
}

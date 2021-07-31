package swea;

import java.util.Scanner;


public class SWEA_1217_거듭제곱 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1217
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD&categoryId=AV14dUIaAAUCFAYD&categoryType=CODE&problemTitle=1217&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			res[t] = cal(N, 0);
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		sc.close();
	}
	
	public static int cal(int res, int turn) {
		if(turn == M) return 1;
		return res * cal(res, turn+1);
	}
}

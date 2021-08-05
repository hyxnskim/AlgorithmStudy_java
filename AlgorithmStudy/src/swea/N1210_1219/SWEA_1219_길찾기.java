package swea.N1210_1219;

import java.util.Scanner;

public class SWEA_1219_길찾기 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1219
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD&categoryId=AV14geLqABQCFAYD&categoryType=CODE&problemTitle=1219&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static boolean[][] ways;
	public static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			int edge = sc.nextInt();
			ways = new boolean[100][100];

			// 입력
			for(int i = 0; i < edge; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				ways[x][y] = true;
			}
			
			flag = false;
			dfs(0);
			if(flag) res[t] = 1;
			else res[t] = 0;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		
		sc.close();
	}
	
	public static void dfs(int now) {

		for(int i = 0; i < 100; i++) {
			if(ways[now][i] == true) {
				ways[now][i] = false;
				if(i == 99) {
					flag = true;
					return;
				} else {
					dfs(i);
				}
			}
		}
	}
}

package swea.N1210_1219;

import java.util.Scanner;

public class SWEA_1216_Palindrome2 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1216
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14Rq5aABUCFAYi&categoryId=AV14Rq5aABUCFAYi&categoryType=CODE&problemTitle=1216&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int S = 100;
	public static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			map = new char[S][S];
			int max = 0;
			
			// 입력
			for(int i = 0; i < S; i++) {
				String tmp = sc.next();
				for(int j = 0; j < S; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			
			// solution
			int tmp;
			for(int i = 0; i < S; i++) {
				tmp = isPal_row(i);
				if(tmp > max) max = tmp;
				tmp = isPal_col(i);
				if(tmp > max) max = tmp;
			}
			
			res[t] = max;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		
		sc.close();
	}
	
	public static int isPal_row(int x) {
		int max = 0;
		int len = 0;
		
		for(int s = 0; s < S; s++) {
			boolean flag = true;
			
			int e = S -1;
			for(; e >= s; e--) {
				int t1 = s, t2 = e;
				flag = true;
				while(t1 <= t2) {
					if(map[x][t1] != map[x][t2]) {
						flag = false;
						break;
					}
					t1++; t2--;
				}
				if(flag) break;
			}
			if(flag && (len = e - s + 1) > max) max = len;
		}
		
		return max;
	}
	
	public static int isPal_col(int y) {
		int max = 0;
		int len = 0;
		
		for(int s = 0; s < S; s++) {
			boolean flag = true;
			
			int e = S -1;
			for(; e >= s; e--) {
				int t1 = s, t2 = e;
				flag = true;
				while(t1 <= t2) {
					if(map[t1][y] != map[t2][y]) {
						flag = false;
						break;
					}
					t1++; t2--;
				}
				if(flag) break;
			}
			if(flag && (len = e - s + 1) > max) max = len;
		}
		
		return max;
	}
}

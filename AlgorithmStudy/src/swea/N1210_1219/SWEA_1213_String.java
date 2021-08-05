package swea.N1210_1219;

import java.util.Scanner;

public class SWEA_1213_String {
	
	/**
	 * <pre>
	 * My solution for SWEA_1213
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi&categoryId=AV14P0c6AAUCFAYi&categoryType=CODE&problemTitle=1213&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
			sc.nextInt();
			String target = sc.next();
			String str = sc.next();
			
			int idx = -1;
			int cnt = 0;
					
			while(true) {
				idx = str.indexOf(target, idx+1);
				if(idx >= 0) cnt++;
				else break;
			}
			
			res[t] = cnt;
		}

		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		sc.close();
	}
}

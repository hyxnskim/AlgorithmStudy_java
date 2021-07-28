package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1220_Magnetic {
	
	/**
	 * <pre>
	 * My solution for SWEA_1220
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD&categoryId=AV14hwZqABsCFAYD&categoryType=CODE&problemTitle=1220&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int[][] table;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		int S = 100;
		
		for(int t = 0; t < T; t++) {
			table = new int[S][S];
			sc.nextInt();
			
			// 입력
			for(int i = 0; i < S; i++)
				for(int j = 0; j < S; j++) 
					table[i][j] = sc.nextInt();
			
			while(true) {
				
				int[][] newTable = new int[S][S];
				
				for(int i = 0; i < S; i++) {
					for(int j = 0; j < S; j++) {
						if(table[j][i] == 1) {
							if(j+1 == S) newTable[j][i] = 0;
							else if(j+1 < S && table[j+1][i] == 0 && newTable[j+1][i] == 0) newTable[j+1][i] = 1;
							else newTable[j][i] = 1;
						} else if(table[j][i] == 2) {
							if(j-1 == -1) newTable[j][i] = 0;
							else if(j-1 >= 0 && table[j-1][i] == 0 && newTable[j-1][i] == 0) newTable[j-1][i] = 2;
							else newTable[j][i] = 2;
						}
					}
				}
				
				if(Arrays.deepEquals(table, newTable)) break;
				table = newTable;
			}	// end while
			
			int cnt = 0;
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					int tmp = table[j][i];
					if(tmp != 1) continue;
					
					j++;
					while(j < S && table[j][i] == 1) j++;
					if(table[j][i] == 2) cnt++;
					
				}
			}
			res[t] = cnt;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		
		sc.close();
	}
}

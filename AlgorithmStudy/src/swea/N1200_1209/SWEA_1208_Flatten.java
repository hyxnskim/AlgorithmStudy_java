package swea.N1200_1209;

import java.util.Scanner;

public class SWEA_1208_Flatten {
	
	/**
	 * <pre>
	 * My solution for SWEA_1208
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=1208&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int i = 0; i < T; i++) {
			int dump = sc.nextInt();
			int[] height = new int[100];
			
			int max = 1; int max_idx = 0;
			int min = 100; int min_idx = 0;
			for(int j = 0; j < 100; j++) {
				int tmp = sc.nextInt();
				if(tmp > max) {
					max = tmp;
					max_idx = j;
				}
				if(tmp < min) {
					min = tmp;
					min_idx = j;
				}
				height[j] = tmp;
			}
			
			while(dump > 0) {
				height[max_idx]--;
				height[min_idx]++;
				
				max = 1;
				min = 100;
				for(int j = 0; j < 100; j++) {
					int tmp = height[j];
					if(tmp > max) {
						max = tmp;
						max_idx = j;
					}
					if(tmp < min) {
						min = tmp;
						min_idx = j;
					}
				}
				dump--;
				if(max - min == 1 || max - min == 0) break;
			}
			res[i] = max - min;
		}
		
		for(int i = 0; i < T; i++) {
			System.out.printf("#%d %d\n", i+1, res[i]);
		}
		sc.close();
	}
}

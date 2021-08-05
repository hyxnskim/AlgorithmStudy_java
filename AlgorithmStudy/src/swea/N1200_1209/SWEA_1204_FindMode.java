package swea.N1200_1209;

import java.util.Scanner;

public class SWEA_1204_FindMode {
	
	/**
	 * <pre>
	 * My solution for SWEA_1204
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=1204&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] res = new int[T];
		
		for(int i = 0; i < T; i++) {
			int[] scores = new int[101];
			sc.nextInt();
			
			int max = 0;
			for(int j = 0; j < 1000; j++) {
				int score = sc.nextInt();
				scores[score]++;
				if(scores[score] > max) max = scores[score];
			}
			
			int j = 100;
			for(; j >= 0; j--) {
				if(scores[j] == max) break;
			}
			
			res[i] = j;
		}
		
		for(int i = 0; i < T; i++)
			System.out.printf("#%d %d\n", i+1, res[i]);
		
		sc.close();
	}

}

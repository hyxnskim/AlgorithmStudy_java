package swea.N1220_1229;

/**
 * <pre>
 * My solution for SWEA_1221
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1221_GNS {
	
	static String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 0; t < T; t++) {
			String[] input = sc.nextLine().split(" ");
			int N = Integer.parseInt(input[1]);
			cnt = new int[10];
			
			input = sc.nextLine().split(" ");

			int tmp = -1;
			for(int i = 0; i < N; i++) {
				switch(input[i]) {
					case "ZRO" : tmp = 0; break;
					case "ONE" : tmp = 1; break;
					case "TWO" : tmp = 2; break;
					case "THR" : tmp = 3; break;
					case "FOR" : tmp = 4; break;
					case "FIV" : tmp = 5; break;
					case "SIX" : tmp = 6; break;
					case "SVN" : tmp = 7; break;
					case "EGT" : tmp = 8; break;
					case "NIN" : tmp = 9; break;
				}
				cnt[tmp]++;
			}
			
			System.out.printf("#%d\n", t+1);
			for(int i = 0; i < 10; i++) 
				for(int j = 0; j < cnt[i]; j++)
					System.out.print(nums[i] + " ");
		}
		
		sc.close();
	}
	
}

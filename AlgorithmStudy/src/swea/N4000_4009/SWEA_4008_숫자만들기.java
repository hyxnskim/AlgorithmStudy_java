package swea.N4000_4009;

/**
 * <pre>
 * My solution for SWEA_4008
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	
	static int N;
	static int[] oper;	// +, -, *, /
	static int[] tr;
	static int[] nums;
	static int min, max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			oper = new int[4];
			for(int i = 0; i < 4; i++) {
				oper[i] = sc.nextInt();
			}
			
			nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			dfs(nums[0], 1);
			
			System.out.printf("#%d %d\n", t+1, max - min);
		}
		sc.close();
	}
	
	public static void dfs(int res, int idx) {
		if(idx == N) {
			if(res < min) min = res;
			if(res > max) max = res;
		}
		
		for(int i = 0; i < 4; i++) {
			if(oper[i] != 0) {
				oper[i]--;
				if(i == 0) dfs(res + nums[idx], idx+1);
				else if(i == 1) dfs(res - nums[idx], idx+1);
				else if(i == 2) dfs(res * nums[idx], idx+1);
				else if(i == 3) dfs(res / nums[idx], idx+1);
				oper[i]++;
			}
		}
	}

}
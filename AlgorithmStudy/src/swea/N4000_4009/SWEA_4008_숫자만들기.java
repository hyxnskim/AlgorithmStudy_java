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
			
			oper = new int[N-1];
			tr = new int[N-1];
			int idx = 0;
			for(int i = 0; i < 4; i++) {
				int tmp = sc.nextInt();
				for(int j = 0; j < tmp; j++) {
					oper[idx++] = i;
				}
			}
			
			nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			perm(N-1, N-1);
			
			System.out.printf("#%d %d\n", t+1, max - min);
		}
		sc.close();
	}
	
	static void swap(int i, int j) {
		int t = oper[i];  oper[i] = oper[j]; oper[j] = t;
	}
	
	static void cal_arr() {
		int res = nums[0];
		for (int i = 0; i < N-1; i++) {
			switch(tr[i]) {
			case 0: res += nums[i+1]; break;
			case 1: res -= nums[i+1]; break;
			case 2: res *= nums[i+1]; break;
			case 3: res /= nums[i+1]; break;
			}
		}
		if(res < min) min = res;
		if(res > max) max = res;
	}

	
	static void perm(int n, int r) {
		if (r == 0) cal_arr();
		else {
			for (int i = n - 1; i >= 0; i--) {
				if(i != n-1 && oper[i] == oper[n-1]) continue;
				swap(i, n - 1);
				tr[r - 1] = oper[n - 1];
				perm(n - 1, r - 1);
				swap(i, n - 1);
			}
		}
	}
}
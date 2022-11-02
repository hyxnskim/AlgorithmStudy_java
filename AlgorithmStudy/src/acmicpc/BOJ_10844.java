package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844 {
	
	static int N;
	static Long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1L;
		}
		
		long res = 0;
		
		for(int i = 1; i <= 9; i++) {
			res += sol(N, i);
		}
		System.out.println(res % 1_000_000_000);
		
	}
	
	public static long sol(int digit, int val) { // digit: 자릿수, val: 자릿값
		
		if(digit == 1) {
			return dp[digit][val];
		}
		
		if(dp[digit][val] == null) {
			if(val == 0) {
				dp[digit][val] = sol(digit-1, 1);
			} else if (val == 9) {
				dp[digit][val] = sol(digit-1, 8);
			} else {
				dp[digit][val] = sol(digit-1, val-1) + sol(digit-1, val+1);
			}
		}
		
		return dp[digit][val] % 1_000_000_000;
	}
}

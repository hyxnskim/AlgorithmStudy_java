package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
	
	static Integer[] dp;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		if(N > 1) dp[2] = 1;
		if(N > 2) dp[3] = 1;
		
		
		System.out.println(sol(N));
		
	}
	
	public static int sol(int N) {
		
		if(dp[N] == null) {
			if(N%6 == 0) dp[N] = Math.min(sol(N/3), Math.min(sol(N/2), sol(N-1))) + 1;
			else if(N%3 == 0) dp[N] = Math.min(sol(N/3), sol(N-1)) + 1;
			else if(N%2 == 0) dp[N] = Math.min(sol(N/2), sol(N-1)) + 1;
			else dp[N] = sol(N-1) + 1;
		}
		
		return dp[N];
	}

}

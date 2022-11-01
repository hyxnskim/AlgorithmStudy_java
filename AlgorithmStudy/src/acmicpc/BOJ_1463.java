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
			int A = Integer.MAX_VALUE, B = Integer.MAX_VALUE, C = Integer.MAX_VALUE;
			if(N%3 == 0) A = sol(N/3);
			if(N%2 == 0) B = sol(N/2);
			C = sol(N-1);
			
			dp[N] = Math.min(A, Math.min(B, C)) + 1;
		}
		
		return dp[N];
	}

}

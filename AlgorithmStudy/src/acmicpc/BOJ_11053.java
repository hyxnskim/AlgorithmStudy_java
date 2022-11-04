package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {

	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[N];
		int max = 0;
		dp[0] = 1;
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && arr[j] > arr[max]) max = j;
			}
			dp[i] = dp[max] + 1;
		}
		
		max = 0;
		for(int i = 0; i < N; i++) {
			if(dp[i] > max) max = dp[i];
		}
		
		System.out.println(max);
		
	}

}

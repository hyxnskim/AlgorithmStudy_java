package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579 {

	static int[] arr;
	static Integer[] DP;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		DP = new Integer[N+1];
		
		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		DP[0] = arr[0];
		DP[1] = arr[1];
		if(N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
		
		System.out.println(solution(N));
	}
	
	public static int solution(int idx) {
		if(DP[idx] == null) {
			DP[idx] = Math.max(solution(idx-2), solution(idx-3) + arr[idx-1]) + arr[idx];
		}
		return DP[idx];
	}

}

package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9461 {
	
	static long[] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(sol(N));
		}
	}
	
	public static long sol(int n) {
		if(arr[n] != 0) return arr[n];
		return arr[n] = sol(n-2) + sol(n-3);
	}

}

/**
 * 1 1 1 2 2 3 4 5 7 9
 * 12 16 21 28 37
 */

package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1904 {
	
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[1_000_001];
		arr[1] = 1;
		arr[2] = 2;
		
		System.out.println(sol(N));
	}
	
	static int sol(int n) {
		
		if(arr[n] != 0) return arr[n];
		return arr[n] = (sol(n-1) + sol(n-2)) % 15746;  //N이 커지면 int, long형 범위를 넘어가므로 매번 모듈러 연산 해야함
	}

}

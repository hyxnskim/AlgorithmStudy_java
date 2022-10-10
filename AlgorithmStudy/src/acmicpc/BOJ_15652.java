package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
	
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		sol(0);
		System.out.println(sb.toString());
	}
	
	public static void sol(int depth) {
		
		if(depth == M) {
			for(int i : arr) sb.append(i + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(depth == 0 ||(depth > 0 && arr[depth-1] <= i+1)) {
				arr[depth] = i+1;
				sol(depth+1);
			}
		}
	}
}

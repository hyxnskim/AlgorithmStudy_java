package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
	
	static int[][] arr;
	static int[][] sum;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		sum = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i+1; j++) {
				arr[i][j] += Integer.parseInt(st.nextToken());
			}
		}
		
		sum[0][0] = arr[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i+1; j++) {
				if(j == 0) sum[i][j] = arr[i][j] + sum[i-1][0];
				else if(j == i) sum[i][j] = arr[i][j] + sum[i-1][i-1];
				else sum[i][j] = arr[i][j] + Math.max(sum[i-1][j-1], sum[i-1][j]);
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(sum[N-1][i] > max) max = sum[N-1][i];
		}
		
		System.out.println(max);
	}

}

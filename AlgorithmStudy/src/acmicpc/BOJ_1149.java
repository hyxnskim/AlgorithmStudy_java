package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	
	static int[][] arr;
	static int[][] cost;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		arr = new int[T][3];
		cost = new int[T][3];
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 3; i++) {
			cost[0][i] = arr[0][i];
		}
		
		for(int i = 1; i < T; i++) {
			for(int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {
					if(j == k) continue;
					int tmp = cost[i-1][k] + arr[i][j];
					if(tmp < min) min = tmp;
					
				}
				cost[i][j] = min;
			}
		}
		
		int min = cost[T-1][0];
		for(int i = 1; i < 3; i++) {
			if(cost[T-1][i] < min) min = cost[T-1][i];
		}
		
		System.out.println(min);		
	}
	
}

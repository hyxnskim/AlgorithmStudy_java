package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung_2017_sf_am_1 {
	
	static final int MAX_N = 20;
	
	static int n;
	static int[][] mat;
	static int min = Integer.MAX_VALUE;
	static boolean[] evening = new boolean[MAX_N];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		mat = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
	}
	
	public static void solution() {
		
		int morning = 0, night = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!evening[i] && !evening[j]) morning += mat[i][j];
				else if(evening[i] && evening[j]) night += mat[i][j];
			}
		}
		
		int tmp = Math.abs(morning - night);
		if(tmp < min) min = tmp;
	}
	
	public static void dfs(int idx, int depth) {
		
		if(depth >= n/2) {
			solution();
			return;
		}
		
		if(idx == n) {
			return;
		}
		
		// 아침에 일
		dfs(idx+1, depth);
		
		// 저녁에 일
		evening[idx] = true;
		dfs(idx+1, depth+1);
		evening[idx] = false;
		
		return;
	}

}

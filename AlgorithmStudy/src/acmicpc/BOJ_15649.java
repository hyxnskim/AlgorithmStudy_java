package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	
	static int N, M;
	static boolean[] isVisited;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N];
		arr = new int[M];
		
		dfs(0);
	}
	
	public static void dfs(int depth) {
		
		if(depth == M) {
			for(int i : arr) System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
			if(!isVisited[i]) {
				
				isVisited[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				isVisited[i] = false;
			}
		}
		return;
	}

}

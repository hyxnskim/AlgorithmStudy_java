package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_24479 {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] isVisited;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		isVisited = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
			Collections.reverse(graph[i]);
		}
		
		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(isVisited[i]);
		}
	}
	
	static void bfs(int R) {
		if(isVisited[R] > 0) return;
		
		isVisited[R] = ++cnt;
		
		for(int i : graph[R]) {
			if(isVisited[i] == 0) bfs(i);
		}
	}

}

package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_24444 {

	static ArrayList<Integer>[] graph;
	static int[] isVisited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		isVisited = new int[N+1];
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			 
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for(int i = 0; i <= N; i++) {
			Collections.sort(graph[i]);
			Collections.reverse(graph[i]);
		}
		
		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(isVisited[i]);
		}
	}
	
	static void bfs(int R) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int cnt = 1;
		queue.add(R);
		isVisited[R] = cnt++;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int e : graph[cur]) {
				if(isVisited[e] == 0) {
					isVisited[e] = cnt++;
					queue.add(e);
				}
			}
		}	
	}
}

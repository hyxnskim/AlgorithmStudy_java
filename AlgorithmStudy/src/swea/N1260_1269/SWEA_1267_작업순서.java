package swea.N1260_1269;

import java.util.Scanner;

public class SWEA_1267_작업순서 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1267
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN&categoryId=AV18TrIqIwUCFAZN&categoryType=CODE&problemTitle=1267&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int[][] map;
	public static boolean[] isVisited;
	public static int[] pre;
	public static int V, E;	// 정점의 수, 간선의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int t = 0; t < T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			map = new int[V+1][V+1];
			isVisited = new boolean[V+1];
			pre = new int[V+1];
			
			for(int i = 0; i < V+1; i++) {
				isVisited[i] = false;
			}
			
			int a = 0, b = 0;
			for(int i = 0; i < E; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = 1;
				pre[b]++;
			}
			
			System.out.print("#" + (t+1));
			for(int i = 1; i <= V; i++) {
				if(pre[i] == 0)  dfs(i);
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static void dfs(int now) {
		if(isVisited[now]) return;
		
		System.out.print(" " + now);
		isVisited[now] = true;
		for(int i = 1; i <= V; i++) {
			if(map[now][i] == 1 && !isVisited[i] && --pre[i] == 0) {
				dfs(i);
			}
		}
	}
}

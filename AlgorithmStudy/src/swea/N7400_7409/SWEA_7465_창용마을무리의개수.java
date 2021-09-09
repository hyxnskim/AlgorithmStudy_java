package swea.N7400_7409;

/**
 * <pre>
 * My solution for SWEA_7465
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA_7465_창용마을무리의개수 {
	
	static int N, cnt;
	static int[][] mat;
	static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			
			mat = new int[N+1][N+1];
			int from, to;
			for(int i = 0; i < M; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				mat[from][++mat[from][0]] = to;
				mat[to][++mat[to][0]] = from;
			}
			
			cnt = 0;
			isVisited = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				if(mat[i][0] > 0 && !isVisited[i]) dfs(i);
				else if(mat[i][0] == 0) cnt++;
			}
			
			System.out.printf("#%d %d\n", t+1, cnt);
		}
		
		sc.close();
	}
	
	static void dfs(int x) {
		Stack<Integer> stack = new Stack<>();
		
		cnt++;
		stack.add(x);
		isVisited[x] = true;
		
		int now, tmp;
		while(!stack.isEmpty()) {
			now = stack.pop();
			for(int i = 1; i <= mat[now][0]; i++) {
				tmp = mat[now][i];
				if(!isVisited[tmp]) {
					stack.add(tmp);
					isVisited[tmp] = true;
				}
			}
		}
	}
}

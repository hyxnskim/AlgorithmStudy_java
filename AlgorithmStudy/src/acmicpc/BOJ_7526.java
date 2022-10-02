package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_7526 {
	
	static int N;
	static int[][] mat;
	static boolean[][] isVisited;
	static int[] start, end;
	static int[] dx = {-2, -2, -1, +1, +2, +2, -1, +1};
	static int[] dy = {-1, +1, +2, +2, -1, +1, -2, -2};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++) {
			
			start = new int[2];
			end = new int[2];
			
			N = Integer.parseInt(br.readLine());
			mat = new int[N][N];
			isVisited = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			//////////////////////////////////////////////////////
			
			isVisited[start[0]][start[1]] = true;
			solution();
			System.out.println(mat[end[0]][end[1]]);
		}
		
	}
	
	static void solution() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0] == end[0] && cur[1] == end[1]) break;
			
			for(int i = 0; i < 8; i++) {
				int xx = cur[0] + dx[i];
				int yy = cur[1] + dy[i];
				
				if(isValid(xx, yy) && !isVisited[xx][yy]) {
					queue.add(new int[] {xx, yy});
					mat[xx][yy] = mat[cur[0]][cur[1]] + 1;
					isVisited[xx][yy] = true;
				}
			}
		}		
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}

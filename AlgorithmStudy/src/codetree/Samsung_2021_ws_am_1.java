package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Samsung_2021_ws_am_1 {
	
	static int n, first;
	static ArrayList<Integer>[] friends;
	static ArrayList<Integer> order;
	static int[][] mat;
	static int[] max; // 친구수, 비어있는 칸 수, 행 번호, 열 번호
	static int[] dx = {-1, 1, 0, 0};	// 위, 아래, 왼, 오
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		friends = new ArrayList[n*n+1];
		for(int i = 0; i <= n*n; i++) {
			friends[i] = new ArrayList<>();
		}
		
		order = new ArrayList<>();
		mat = new int[n][n];

		StringTokenizer st;
		for(int i = 1; i <= n*n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			order.add(idx);
			if(i == 1) first = idx;
			
			for(int j = 0; j < 4; j++) {
				friends[idx].add(Integer.parseInt(st.nextToken()));
			}
		}
		/////////////// 입력 완료
		
		solution();
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(calc());
		
		
	}
	
	public static void solution() {
		
		while(!order.isEmpty()) {
			int cur = order.get(0);
			order.remove(0);
			
			if(cur == first) {
				mat[1][1] = cur;
				continue;
			}
			
			max = new int[] {0, 0, n, n};
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					if(mat[i][j] > 0) continue;
					
					int cnt_friends = 0, cnt_blank = 0;
					for(int d = 0; d < 4; d++) {
						int x = i + dx[d];
						int y = j + dy[d];
						
						if(isWall(x, y)) continue;
						
						if(friends[cur].contains(mat[x][y])) cnt_friends++;
						if(mat[x][y] == 0) cnt_blank++;
					}
					
					if(cnt_friends > max[0] || (cnt_friends == max[0] && cnt_blank > max[1]) ||
							(cnt_friends == max[0] && cnt_blank == max[1] && i < max[2]) || 
							(cnt_friends == max[0] && cnt_blank == max[1] && i == max[2] && j < max[3])) max = new int[] {cnt_friends, cnt_blank, i, j};
					
				}
			}
			
//			System.out.printf("%d : (%d, %d)\n", cur, max[2], max[3]);
			mat[max[2]][max[3]] = cur;
		}
	}
	
	public static int calc() {
		int[] score = {0, 1, 10, 100, 1000};
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int x = i + dx[d];
					int y = j + dy[d];
					
					if(!isWall(x, y) && friends[mat[i][j]].contains(mat[x][y])) cnt++;
				}
				answer += score[cnt];
			}
		}
		
		return answer;
	}
	
	public static boolean isWall(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}

}

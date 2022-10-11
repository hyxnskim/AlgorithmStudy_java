package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Samsung_2019_ws_am_2 {
	
	static int n, m, k;
	static ArrayList<Fungi> fungies;
	static int[][] mat;
	static int cnt = 0;
	static int[] dx = {0, -1, 1, 0, 0}; // 0, 위, 아래, 오른쪽, 왼쪽
	static int[] dy = {0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		mat = new int[n+1][m+1];
		
		fungies = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
						
			fungies.add(new Fungi(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
			
			int s = fungies.get(i).s;
			int d = fungies.get(i).d;
			if(d <= 2) fungies.get(i).s = s % (2*n-2);
			else fungies.get(i).s = s %(2*m-2);
		}
		
		for(int i = 0; i < k; i++) {
			Fungi tmp = fungies.get(i);
			mat[tmp.x][tmp.y] = i+1;
		}
		
		solution();
		System.out.println(cnt);
		
	}
	
	public static void solution() {
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(mat[j][i] > 0) {
					System.out.printf("CAUGHT : mat[%d][%d] = %d\n", j, i, mat[j][i]);
					int idx = mat[j][i] - 1;
					cnt += fungies.get(idx).b;
					fungies.remove(idx);
					break;
				}
			}
			
			// mat 초기화 및 곰팡이 이동한 위치 설정
			mat = new int[n+1][m+1];
			move();
			
			for(int ii = 1; ii < n+1; ii++) {
				for(int jj = 1; jj < m+1; jj++) {
					System.out.print(mat[ii][jj] + " ");
				}
				System.out.println();
			}
			System.out.println("===== move " + i + "======");
		}	
	}
	
	public static void move() {
		
		for(int idx = 0;  idx < fungies.size(); idx++) {
			Fungi f = fungies.get(idx);
			
			int x = f.x, y = f.y;	// 현위치
			int s = f.s, d = f.d;	// 이동거리, 방향
			
			System.out.printf("x : %d, y : %d -> ", x, y);
			
			for(int i = 0; i < s; i++) {
				if(x == 1 && d == 1) d = 2;
				else if( x == n && d == 2) d = 1;
				
				if(y == 1 && d == 4) d = 3;
				else if(y == m && d == 3 ) d = 4;
				
				x += dx[d];
				y += dy[d];
			}
			
			System.out.printf("x : %d, y : %d\n", x, y);
			
			fungies.get(idx).x = x;
			fungies.get(idx).y = y;
			fungies.get(idx).d = d;
			
			if(mat[x][y] > 0) {
				int tmp = mat[x][y] - 1;
				if(fungies.get(tmp).b > fungies.get(idx).b) {
					fungies.remove(idx);
				} else {
					fungies.remove(tmp);
					mat[x][y] = idx;
				}
				idx--;
			} else {
				mat[x][y] = idx + 1;
			}
		}
		
	}

}

class Fungi{
	int x, y, s, d, b;	// 행, 열, 이동거리, 이동방향, 크기
	
	Fungi(String x, String y, String s, String d, String b){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.s = Integer.parseInt(s);
		this.d = Integer.parseInt(d);
		this.b = Integer.parseInt(b);
	}
}

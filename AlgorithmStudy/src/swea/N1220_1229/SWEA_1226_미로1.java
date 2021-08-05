package swea.N1220_1229;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1226_미로1 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1226
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=1226&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int map[][];
	public static int S = 16;
	public static int sx, sy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			map = new int[S][S];
			
			for(int i = 0; i < S; i++) {
				String str = sc.next();
				for(int j = 0; j < S; j++) {
					int tmp = Integer.parseInt(str.charAt(j) + "");
					map[i][j] = tmp;
					if(tmp == 2) {
						sx = i; sy = j;
					} 
				}
			}
			System.out.printf("#%d %d\n", t+1, solution());
		}
		
		sc.close();
	}
	
	public static int solution() {
		
		int[] dx = {-1, 1, 0, 0};	// 상하좌우
		int[] dy = {0, 0, -1, 1};
		
		Stack<Status> stack = new Stack<>();
		
		int x = sx, y = sy;
		int xx = 0, yy = 0;
		while(true) {
			if(map[x][y] == 3 ) return 1;
			int dir = 0;
			for(; dir < 4; dir++) {
				xx = x + dx[dir];
				yy = y + dy[dir];
				
				if(!isWall(xx, yy)) break;
			}
			
			if(dir < 4) {
				Status st = new Status(x, y);
				stack.push(st);
				map[x][y] = 1;
				x = xx; y = yy;
			} else {
				map[x][y] = 1;
				if(stack.isEmpty()) return 0;
				Status st = stack.pop();
				x = st.x;
				y = st.y;
			}
		}
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= S || y < 0 || y >= S || map[x][y] == 1);
	}
}

class Status{
	int x, y;
	
	Status(int x, int y){
		this.x = x;
		this.y = y;
	}
}

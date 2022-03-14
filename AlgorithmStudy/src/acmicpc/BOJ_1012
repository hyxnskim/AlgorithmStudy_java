import java.util.Scanner;
import java.util.Stack;

public class BOJ_1012 {
	static int[][] mat;
	static int N;
	static int cnt;
	static int X, Y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 0; t < T; t++) {
			String tmp[] = sc.nextLine().split(" ");
			X = Integer.parseInt(tmp[0]);
			Y = Integer.parseInt(tmp[1]);
			mat = new int[X][Y];
			N = Integer.parseInt(tmp[2]);
			cnt = 0;
			
			for(int n = 0; n < N; n++) {
				tmp = sc.nextLine().split(" ");
				mat[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
			}
			
			for(int i = 0; i < X; i++) {
				for(int j = 0; j < Y; j++) {
					if(mat[i][j] == 1) {
						cnt++;
						solve(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
		
		
		sc.close();
	}
	
	static boolean isWall(int x, int y) {
		return x < 0 || y < 0 || x >= X || y >= Y;
	}
	
	static void solve(int x, int y) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		
		Stack<Position> stack = new Stack<>();
		
		Position now = new Position(x, y);
		stack.add(now);
		mat[x][y] = 0;
		
		int xx, yy;
		while(!stack.isEmpty()) {
			now = stack.pop();
			
			for(int i = 0; i < 4; i++) {
				xx = now.x + dx[i];
				yy = now.y + dy[i];
				
				if(!isWall(xx, yy) && mat[xx][yy] == 1) {
					stack.add(new Position(xx, yy));
					mat[xx][yy] = 0;
				}
			}
		}
		
	}

}

class Position{
	int x, y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}

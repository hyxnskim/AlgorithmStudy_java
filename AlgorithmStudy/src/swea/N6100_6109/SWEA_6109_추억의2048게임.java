package swea.N6100_6109;

/**
 * <pre>
 * My solution for SWEA_6109
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_6109_추억의2048게임 {
	
	public static int S;
	public static int dx, dy;
	public static int[][] map;
	public static boolean isPos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			S = sc.nextInt();
			direction(sc.next());
			
			// 입력
			map = new int[S][S];
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			if(isPos) {
				assemble_A();
				solution_A();
				assemble_A();
			} else {
				assemble_B();
				solution_B();
				assemble_B();
			}
			
			System.out.println("#" + (t+1));
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
	
	public static void direction(String dir) {
		switch(dir) {
		case "left":
			dx = 0; dy = -1;
			isPos = true;
			break;
		case "right":
			dx = 0; dy = 1;
			isPos = false;
			break;
		case "up":
			dx = -1; dy = 0;
			isPos = true;
			break;
		case "down":
			dx = 1; dy = 0;
			isPos = false;
			break;
		default :
			System.out.println("Direction Error");
		}
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= S || y < 0 || y >= S);
	}
	
	public static void assemble_A() {
		int x, y;
		
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				if(map[i][j] == 0) continue;
				
				x = i; y = j;
				
				while(true) {
					if(isWall(x+dx, y+dy) || map[x+dx][y+dy] != 0) break;
					x += dx;
					y += dy;
				}
				
				if(x != i || y != j) {
					map[x][y] = map[i][j];
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void solution_A() {
		int x, y;
		
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				if(map[i][j] == 0) continue;
				
				x = i + dx;
				y = j + dy;
				
				if(!isWall(x, y) && map[i][j] == map[x][y]) {
					map[i][j] = 0;
					map[x][y] *= 2;
				}
			}
		}
	}

	public static void assemble_B() {
		int x, y;
		
		for(int i = S - 1; i >= 0; i--) {
			for(int j = S - 1; j >= 0; j--) {
				if(map[i][j] == 0) continue;
				
				x = i; y = j;
				
				while(true) {
					if(isWall(x+dx, y+dy) || map[x+dx][y+dy] != 0) break;
					x += dx;
					y += dy;
				}
				
				if(x != i || y != j) {
					map[x][y] = map[i][j];
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void solution_B() {
		int x, y;
		
		for(int i = S - 1; i >= 0; i--) {
			for(int j = S - 1; j >= 0; j--) {
				if(map[i][j] == 0) continue;
				
				x = i + dx;
				y = j + dy;
				
				if(!isWall(x, y) && map[i][j] == map[x][y]) {
					map[i][j] = 0;
					map[x][y] *= 2;
				}
			}
		}
	}
}

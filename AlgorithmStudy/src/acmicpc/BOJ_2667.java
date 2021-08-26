package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2667
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2667 {
	
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String stmp = sc.next();
			for(int j = 0; j < stmp.length(); j++) {
				map[i][j] = Integer.parseInt(stmp.charAt(j) + "");
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					list.add(dfs(i, j));
					cnt++;
				}
			}
		}
		
		list.sort(null);
		System.out.println(cnt);
		for(int i = 0; i < cnt; i++) {
			System.out.println(list.get(i));
		}
		
		
		sc.close();
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y  < 0 || y >= N);
	}
	
	public static int dfs(int x, int y) {
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Stack<Position> stack = new Stack<>();
		
		Position now = new Position(x, y);
		stack.add(now);
		map[x][y] = 0;
		
		int xx, yy;
		int cnt = 1;
		while(!stack.isEmpty()) {
			now = stack.pop();
			
			for(int i = 0; i < 4; i++) {
				xx = now.x + dx[i];
				yy = now.y + dy[i];
				if(!isWall(xx, yy) && map[xx][yy] == 1) {
					stack.add(new Position(xx, yy));
					map[xx][yy] = 0;
					cnt++;
				}
			}
			
		}
		return cnt;
	}
	
}

class Position{
	int x, y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

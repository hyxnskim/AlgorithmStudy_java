package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2468
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2468 {
	
	static int N;
	static int[][] mat;
	static int[][] newMat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mat = new int[N][N];
		
		int maxHeight = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if(tmp > maxHeight) maxHeight = tmp;
				mat[i][j] = tmp;
			}
		}
		
		int[] heights = new int[maxHeight + 1];
		for(int i = 0; i < maxHeight; i++) {
			newMat = copyMat(mat, i);
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(newMat[j][k] == 1) {
						dfs(j, k);
						cnt++;
					}
				}
			}
			heights[i] = cnt;
		}
		
		int max = 0;
		for(int i = 0; i <= maxHeight; i++) {
			if(heights[i] > max) max = heights[i];
		}
		
		System.out.println(max);
		
		sc.close();
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
	
	public static int[][] copyMat(int[][] orim, int height){
		int[][] newm = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(orim[i][j] <= height) newm[i][j] = 0;
				else newm[i][j] = 1;
			}
		}
		return newm;
	}
	
	public static void dfs(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Stack<Position> stack = new Stack<>();
		
		Position now = new Position(x, y);
		stack.add(now);
		newMat[x][y] = 0;
		
		int xx, yy;
		while(!stack.isEmpty()) {
			now = stack.pop();
			
			for(int i = 0; i < 4; i++) {
				xx = now.x + dx[i];
				yy = now.y + dy[i];
				if(!isWall(xx, yy) && newMat[xx][yy] == 1) {
					stack.add(new Position(xx, yy));
					newMat[xx][yy] = 0;
				}
			}
		}
	}

}

package swea.N1260_1269;

/**
 * <pre>
 * My solution for SWEA_1260
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1260_화학물질2 {

	static int N;
	static int[][] mat;
	static int[][] dp;
	static ArrayList<Area> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			mat = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			list = new ArrayList<Area>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mat[i][j] > 0) list.add(solution(i, j));
				}
			}
			
			// 맨 앞 찾기
			Area start = null;
			for(int i = 0; i < list.size(); i++) {
				boolean flag = false;;
				int height = list.get(i).height;
				for(int j = 0; j < list.size(); j++) {
					if(i == j) continue;
					if(list.get(j).width == height) flag = true;
				}
				if(!flag) {
					start = list.get(i);
					list.remove(i);
					break;
				}
			}
			
			ArrayList<Area> newList = new ArrayList<Area>();
			newList.add(start);
			// 연결
			while(!list.isEmpty()) {
				for(int i = 0; i < list.size(); i++) {
					Area now = list.get(i);
					if(now.height == start.width) {
						newList.add(now);
						start = now;
						list.remove(i);
					}
				}
			}
			list = newList;
			
			int size = list.size();
			dp = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					dp[i][j] = -1;
				}
			}
			int cnt = cal(0, size-1);

			System.out.printf("#%d %d\n", t+1, cnt);

		}
		
		
		sc.close();

	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N || mat[x][y] <= 0);
	}
	
	public static Area solution(int x, int y) {
		
		int[] dx = {1, 0};	// 하, 우
		int[] dy = {0, 1};
		
		int width = 1;
		int height = 1;
		
		mat[x][y] = -1;
		int xx = x + dx[0], yy = y + dy[0];
		
		for(int i = 0; i < 2; i++) {
			
			while(!isWall(xx, yy)) {
				mat[xx][yy] = -1;
				
				if(i == 0) height++;
				else width++;
				
				xx += dx[i]; yy += dy[i];
			}
			
			if(i == 0) {
				xx -= 1; yy += 1;
			} else {
				yy -= 1;
			}
		}
		
		for(int i = x; i < xx; i++) {
			for(int j = y+1; j <= yy; j++) {
				mat[i][j] = -1;
			}
		}
		
		return new Area(height, width);
	}
	
	public static int cal(int left, int right) {
		if(left == right) return 0;
		if(dp[left][right] != -1) return dp[left][right];
		
		int min = Integer.MAX_VALUE;
		for(int i = left; i < right; i++) {
			int calLeft = cal(left, i);
			int calRight = cal(i+1, right);
			
			int num = list.get(left).height * list.get(i).width * list.get(right).width;
			min = Math.min(calLeft + calRight + num, min);
		}
		
		return dp[left][right] = min;
	}
}

class Area{
	int height, width;
	Area(int height, int width){
		this.height = height;
		this.width = width;
	}
}
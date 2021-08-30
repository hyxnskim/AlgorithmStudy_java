package swea.N5650_5659;

/**
 * <pre>
 * My solution for SWEA_5650
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

/**
 * 1
5
0 6 7 6 7
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
5 5 5 5 5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	
	static int N;
	static int[][] mat;
	static int[][] wormhole;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	
		for(int t = 0; t < T; t++) {
			
			N = sc.nextInt();
			mat = new int[N][N];
			wormhole = new int[11][2];
			
			for(int i = 0; i < 11; i++) wormhole[i][0] = -1;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = sc.nextInt();
					mat[i][j] = tmp;
					if(tmp >= 6 && tmp <= 10) {
						if(wormhole[tmp][0] == -1) {
							wormhole[tmp][0] = i; wormhole[tmp][1] = j;
						}
						else {
							wormhole[tmp-5][0] = i; wormhole[tmp-5][1] = j;
						} 
					}
				}
			}
			
			List<Integer> scores = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mat[i][j] == 0) {
						for(int k = 0; k < 4; k++) {
							scores.add(pinball(i, j, k));
						}
					}
				}
			}
			
			scores.sort(null);
			System.out.printf("#%d %d\n", t+1, scores.get(scores.size() - 1));
		}
		sc.close();
	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N);
	}
	
	public static int changeDir(int curDir, int block) {
		
		if(curDir == 0) {
			if(block == 1 || block == 4 || block == 5) return 1;
			if(block == 2) return 3;
			if(block == 3) return 2;
		} else if(curDir == 1) {
			if(block == 2 || block == 3 || block == 5) return 0;
			else if(block == 1) return 3;
			else if(block == 4) return 2;
		} else if(curDir == 2) {
			if(block == 3 || block == 4 || block == 5) return 3;
			else if(block == 1) return 0;
			else if(block == 2) return 1;
		} else if(curDir == 3) {
			if(block == 1 || block == 2 || block == 5) return 2;
			else if(block == 3) return 1;
			else if(block == 4) return 0;
		}
		
		return -1;
	}
	
	public static int changeDir(int curDir) {
		if(curDir == 0) return 1;
		else if(curDir == 1) return 0;
		else if(curDir == 2) return 3;
		else if(curDir == 3) return 2;
		return -1;
	}
	
	public static int pinball(int x, int y, int curDir) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt = 0;
		
		int xx = x + dx[curDir];
		int yy = y + dy[curDir];
		
		while(!((xx == x && yy == y) || (!isWall(xx, yy) && mat[xx][yy] == -1))) {
			cnt++;
			if(isWall(xx, yy)) {
				curDir = changeDir(curDir);
				xx += dx[curDir]; yy += dy[curDir];
			} else {
				int val = mat[xx][yy];
				if(val == 0) {
					xx += dx[curDir]; yy += dy[curDir];
					cnt--;
				} else if(val >= 1 && val <= 5) {
					curDir = changeDir(curDir, val);
					xx += dx[curDir]; yy += dy[curDir];
				} else {
					cnt--;
					if(xx == wormhole[val][0]) {
						xx = wormhole[val-5][0] + dx[curDir];
						yy = wormhole[val-5][1] + dy[curDir];
						wormhole[val][0] = -1;
					} else if (xx == wormhole[val-5][0]) {
						xx = wormhole[val][0] + dx[curDir];
						yy = wormhole[val][1] + dy[curDir];
						wormhole[val-5][0] = -1;
					} else {
						if(x == 0 || y == 0 || x == N-1 || y == N-1) return 1;
						else return 0;
					}
				}
			}
		}
		return cnt;
	}

}


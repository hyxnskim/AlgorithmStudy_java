package swea.N1250_1259;

/**
 * <pre>
 * My solution for SWEA_1258
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class SWEA_1258_행렬찾기 {
	
	static int N;
	static int[][] mat;

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
			
			ArrayList<Ans> list = new ArrayList<Ans>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mat[i][j] > 0) list.add(solution(i, j));
				}
			}
			
			Collections.sort(list, new Comparator<Ans>() {
				@Override
				public int compare(Ans n1, Ans n2) {
					if(n1.size < n2.size) return -1;
					else if(n1.size > n2.size) return 1;
					else {
						if(n1.height < n2.height) return -1;
						else if(n1.height > n2.height) return 1;
						else return 0;
					}
				}
			});
			
			System.out.printf("#%d %d ", t+1, list.size());
			for(int i = 0; i < list.size(); i++) {
				Ans ans = list.get(i);
				System.out.print(ans.height + " " + ans.width + " ");
			}
			System.out.println();
		}
		
		
		sc.close();

	}
	
	public static boolean isWall(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= N || mat[x][y] <= 0);
	}
	
	public static Ans solution(int x, int y) {
		
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
		
		return new Ans(width, height, width*height);
	}

}

class Ans{
	int width, height, size;
	Ans(int width, int height, int size){
		this.width = width;
		this.height = height;
		this.size = size;
	}
}

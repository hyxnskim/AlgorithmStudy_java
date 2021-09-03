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
			
			ArrayList<Area> list = new ArrayList<Area>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mat[i][j] > 0) list.add(solution(i, j));
				}
			}
			
//			System.out.println();
//			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).height + " " + list.get(i).width);
//			}
			
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
//			System.out.println();
//			System.out.printf("%d %d ", start.height, start.width);
			while(!list.isEmpty()) {
				for(int i = 0; i < list.size(); i++) {
					Area now = list.get(i);
					if(now.height == start.width) {
//						System.out.print(now.height + " " + now.width + " ");
						newList.add(now);
						start = now;
						list.remove(i);
					}
				}
			}
			list = newList;
//			System.out.println();
			
			int cnt = 0;
			while(list.size() > 1) {
				int min = 0;
				for(int i = 0; i < list.size() - 1; i++) {
					if(list.get(i).height < list.get(min).height) {
						min = i;
					}
				}
				
				Area a1 = list.get(min);
				Area a2 = list.get(min + 1);
				
				cnt += a1.height * a1.width * a2.width;
				
				Area newArea = new Area(a1.height, a2.width);
				list.remove(min + 1);
				list.set(min, newArea);
			}
			
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
}

class Area{
	int height, width;
	Area(int height, int width){
		this.height = height;
		this.width = width;
	}
}

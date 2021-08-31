package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1247
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1247_최적경로 {
	
	static int N;
	static int[][] loc;
	static int[] work, home;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			loc = new int[N][2];
			work = new int[2];
			home = new int[2];
			
			for(int i = 0; i < 2; i++) {
				work[i] = sc.nextInt();
			}
			
			for(int i = 0; i < 2; i++) {
				home[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				loc[i][0] = sc.nextInt();
				loc[i][1] = sc.nextInt();
			}
			
			res = 0;
			for(int i = 0; i < N; i++) {
				boolean[] isVisited = new boolean[N];
				isVisited[i] = true;
				trace(work, loc[i], isVisited, 0);
			}
			
			System.out.printf("#%d %d\n", t+1, res);
		}
		sc.close();
	}
	
	public static void trace(int[] before, int[] cur, boolean[] isVisited, int distance) {
		boolean flag = false;
		boolean[] newVisited;
		distance += calDistance(before, cur);
		
		for(int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				newVisited = copy(isVisited);
				newVisited[i] = true;
				flag = true;
				trace(cur, loc[i], newVisited, distance);
			}
		}
		if(!flag) {
			int tmp = distance + calDistance(cur, home);
			if(res == 0 || res > tmp) res = tmp;
		}
		
	}
	
	public static int calDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
	public static boolean[] copy(boolean[] arr) {
		boolean[] newArr = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
}

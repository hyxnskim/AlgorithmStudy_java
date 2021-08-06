package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1245
 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15MeBKAOgCFAYD&categoryId=AV15MeBKAOgCFAYD&categoryType=CODE&problemTitle=1245&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1245_균형점 {

	public static int N;
	public static int[] pos;
	public static int[] mass;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++){
			N = sc.nextInt();
			pos = new int[N];
			mass = new int[N];
			
			for(int i = 0; i < N; i++) pos[i] = sc.nextInt();
			for(int i = 0; i < N; i++) mass[i] = sc.nextInt();
			
			System.out.print("#" + (t+1));
			for(int i = 0; i < N - 1; i++) {
				double ans = solution(i, 0, (pos[i] + pos[i+1])/2.0, pos[i], pos[i+1]);
				System.out.printf(" %.10f", ans);
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static double solution(int position, int depth, double cur, double left, double right) {
		if(depth > 50) return cur;
		double before = 0.0;
		double after = 0.0;
		
		int i = 0;
		for(; i <= position; i++) {
			before += (double)mass[i] / Math.pow(cur - pos[i], 2);
		}
		for(; i < N; i++) {
			after += (double)mass[i] / Math.pow(cur - pos[i], 2);
		}
		
		if(before == after) return cur;
		
		double res = 0.0;
		if(before < after) {
			res = solution(position, depth + 1, (left + cur)/2.0 , left, cur);
		} else {
			res = solution(position, depth + 1, (cur + right)/2.0, cur, right);
		}
		return res;
	}
}

package acmicpc;

import java.util.Scanner;

public class BOJ_4344 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/4344
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		double[] res = new double[T];
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] scores = new int[N];
			
			int sum = 0;
			for(int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				scores[j] = tmp;
				sum += tmp;
			}
			
			double avg = (double)sum / N;
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(scores[j] > avg) cnt++;
			}
			
			res[i] = (double)(cnt * 100) / N;
		}
		
		for(int i = 0; i < T; i++) {
			System.out.printf("%.3f%%\n", res[i]);
		}
		
		sc.close();
	}
}

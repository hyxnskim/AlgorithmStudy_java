package acmicpc;

import java.util.Scanner;

public class BOJ_1546 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/1546
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if(tmp > max) max = tmp;
			sum += tmp;
		}
		
		System.out.println((((double)sum * 100) / max) / N);
		
		sc.close();
	}
}

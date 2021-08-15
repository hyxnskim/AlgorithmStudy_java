package acmicpc;

import java.util.Scanner;

public class BOJ_10872 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/10872
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int res = 1;
		for(int i = 2; i <= N; i++) {
			res *= i;
		}
		System.out.println(res);
		
		sc.close();
	}

}

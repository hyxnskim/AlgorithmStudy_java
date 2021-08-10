package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/11720
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		long l = 0;
		for(int i = 0; i < N; i++) {
			l += (int)(str.charAt(i) - '0');
		}
		System.out.println(l);
		
		sc.close();
	}

}

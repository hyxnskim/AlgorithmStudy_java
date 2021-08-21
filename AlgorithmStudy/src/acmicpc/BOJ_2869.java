package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2869
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		System.out.println((int)Math.ceil((double)(V - B) / (A - B)));
		
		sc.close();
	}

}

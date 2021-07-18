package acmicpc;

import java.util.Scanner;

public class Bj_15829 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/15829
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 31;
		int M = 1234567891;
		
		int L = sc.nextInt();
		String str = sc.next();
		
		long hash = 0;
		for(int i = 0; i < L; i++) {
			hash += ((int)(str.charAt(i) - 'a') + 1) * Math.pow(r, i);
		}
		hash %= M;
		System.out.println(hash);
		
		sc.close();
	}
}

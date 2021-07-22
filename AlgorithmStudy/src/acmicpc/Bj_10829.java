package acmicpc;

import java.util.Scanner;

public class Bj_10829 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/10829
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		toBin(N);
		
		sc.close();
	}
	
	public static void toBin(long N) {
		StringBuffer str = new StringBuffer();
		
		while(N >= 1) {
			str.append(N%2);
			N /= 2;
		}
		
		StringBuffer res = new StringBuffer();
		for(int i = str.length() - 1; i >= 0; i--) {
			res.append(str.charAt(i));
		}
		
		System.out.println(res);
	}
}

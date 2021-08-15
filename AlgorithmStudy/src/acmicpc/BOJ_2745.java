package acmicpc;

import java.util.Scanner;

public class BOJ_2745 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/2745
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int toDec(String origin, int numeral) {
		int len = origin.length();
		int result = 0;

		for(int i = 0; i < len; i++) {
			char now = origin.charAt(i);
			int nowInt;
		
			if(now >= '0' && now <= '9') {
				nowInt = now - '0';
			} else {
				nowInt = (now - 'A') + 10;
			}
			result += nowInt * Math.pow(numeral, len - i - 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int B = sc.nextInt();
		System.out.println(toDec(N, B));
		
		sc.close();
	}
}
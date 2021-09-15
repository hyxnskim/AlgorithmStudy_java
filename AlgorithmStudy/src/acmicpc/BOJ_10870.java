package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10870
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(cal(n));
		
		sc.close();
	}
	
	static int cal(int n) {
		
		if(n <= 1) return n;
		else return cal(n-1) + cal(n-2);
		
	}

}

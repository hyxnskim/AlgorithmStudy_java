package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1712
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int ans = 0;
		if(C != B) ans = A / (C - B) + 1;
		
		if(ans <= 0) System.out.println(-1);
		else System.out.println(ans);
		
		sc.close();
	}

}

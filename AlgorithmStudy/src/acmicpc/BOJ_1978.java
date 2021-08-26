package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1978
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(isSosu(sc.nextInt())) cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static boolean isSosu(int n) {
		
		if(n == 1) return false;
		for(int i = 2; i <= n/2; i++) {
			if(n%i == 0) return false;
		}

		return true;
	}

}

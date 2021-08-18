package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2292
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] list = new long[20000];
		int idx = 0;
		long n = 1;
		
		while(n < 1_000_000_000) {
			n = n + 6 * idx;
			list[idx++] = n;
		}
		
		long N = sc.nextLong();
		int i = 0;
		for(; i <= idx; i++) {
			if(list[i] >= N) break;
		}
		
		System.out.println(i+1);
		
		sc.close();
	}
}

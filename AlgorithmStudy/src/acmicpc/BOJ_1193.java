package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1193
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] list = new long[20000];
		int idx = 1;
		long n = 0;
		
		while(n < 10_000_000) {
			n = n + idx;
			list[idx-1] = n;
			idx++;
		}
		
		long N = sc.nextLong();
		int i = 0;
		for(; i <= idx; i++) {
			if(list[i] >= N) break;
		}
		
		int order = 0;
		if(i > 0) {
			for(long j = (list[i-1] + 1); j <= list[i]; j++, order++) {
				if(j == N) break;
			}
		}
		
		int x, y;
		if(i % 2 == 0) {
			x = i + 1;y = 1;
			
			for(i = 0; i < order; i++) {
				x--; y++;
			}
		} else {
			x = 1; y = i + 1;
			
			for(i = 0; i < order; i++) {
				x++; y--;
			}
		}
		
		System.out.println(x + "/" + y);
		
		sc.close();
	}

}

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
		
		int n = A - B;
		int cnt = 0;
		int i = 1;
		for(; i < V; i++) {
			cnt += n;
			if(cnt >= V - B) break;
		}
		
		System.out.println(i);
		
		sc.close();
	}

}

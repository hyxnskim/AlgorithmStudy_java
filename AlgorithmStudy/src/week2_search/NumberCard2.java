package week2_search;

import java.util.Scanner;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10816
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class NumberCard2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] have = new int[20000001];
		for (int i = 0; i < N; ++i) {
			 have[sc.nextInt()+10000000]++;
		}
		
		int M = sc.nextInt();
		for (int i = 0; i < M; ++i) {
			sb.append(have[sc.nextInt()+10000000]+" ");
		}		
		System.out.println(sb.toString());
	}
}

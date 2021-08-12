package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2675
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int times = sc.nextInt();
			String str = sc.next();
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				for(int j = 0; j < times; j++) sb.append(c);
			}
			
			System.out.println(sb);
		}
		sc.close();
	}
}

package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10809
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] cnt = new int[26];
		for(int i = 0; i < 26; i++) {
			cnt[i] = -1;
		}
		
		String str = sc.next();

		for(int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i)-'a';
			if(cnt[idx] == -1) cnt[idx] = i;
		}
		
		for(int i : cnt) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}
}

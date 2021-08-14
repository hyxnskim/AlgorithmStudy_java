package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1157
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int[] cnt = new int[26];
		
		for(char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z') {
				cnt[c - 'A']++;
			} else if(c >= 'a' && c <= 'z') {
				cnt[c - 'a']++;
			}
		}
		
		int max_idx = 0;
		int max_cnt = 0;
		for(int i = 01; i < 26; i++) {
			if(cnt[i] > cnt[max_idx]) {
				max_idx = i;
				max_cnt = 0;
			} else if(cnt[i] == cnt[max_idx]) {
				max_cnt++;
			}
		}
		
		if(max_cnt > 0) System.out.println("?");
		else System.out.println((char)('A' + max_idx));
		
		
		sc.close();
	}

}

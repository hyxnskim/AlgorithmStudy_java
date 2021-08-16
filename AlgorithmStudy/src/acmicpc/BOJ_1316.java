package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1316
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(isGroup(sc.next())) cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static boolean isGroup(String str) {
		int[] chars = new int[26];
		int len = str.length();
		
		for(int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if(chars[c-'a'] > 0) return false;
			chars[c-'a']++;
			
			while(i+1 < len && str.charAt(i+1) == c) i++;
		}
		return true;
	}

}

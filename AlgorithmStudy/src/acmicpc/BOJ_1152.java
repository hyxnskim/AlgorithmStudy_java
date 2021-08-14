package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1152
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		
		int cnt = arr.length;
		for(String s : arr) {
			if(s.equals("")) cnt--;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}

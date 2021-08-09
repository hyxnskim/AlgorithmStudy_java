package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1065
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(isHan(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static boolean isHan(int num) {
		
		if(num <= 99) return true;
		
		int[] arr = new int[4];
		int len = 0;
		
		while(num >= 1) {
			arr[len++] = num % 10;
			num /= 10;
		}
		
		int diff = arr[1] - arr[0];
		for(int i = 1; i < len - 1; i++) {
			if(arr[i+1] - arr[i] != diff)
				return false;
		}
		return true;
	}

}

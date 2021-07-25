package acmicpc;

import java.util.Scanner;

public class BOJ_3052 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/3052
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mod = new int[42];
		int res = 0;
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			int tmp = arr[i] % 42;
			if(mod[tmp] == 0) {
				mod[tmp]++;
				res++;
			}
		}
		System.out.println(res);
	}
}

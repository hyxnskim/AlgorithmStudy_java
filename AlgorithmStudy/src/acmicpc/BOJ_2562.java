package acmicpc;

import java.util.Scanner;

public class BOJ_2562 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/2652
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int max = 0;
		int tmp = 0;
		for(int i = 0; i < 9; i++) {
			tmp = sc.nextInt();
			arr[i] = tmp;
			if(tmp > max) max = tmp;
		}
		
		System.out.println(max);
		for(int i = 0; i < 9; i++) {
			if(arr[i] == max) {
				System.out.println(i+1);
				break;
			}
		}
		sc.close();
	}
}

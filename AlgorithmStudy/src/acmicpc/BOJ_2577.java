package acmicpc;

import java.util.Scanner;

public class BOJ_2577 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/2577
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] res = new int[10];
		
		int mul = 1;
		for(int i = 0; i < 3; i++) {
			mul *= sc.nextInt();
		}
		while(mul > 0) {
			res[mul % 10] += 1;
			mul /= 10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(res[i]);
		}
	
		sc.close();
	}

}

package acmicpc;

import java.util.Scanner;

public class Bj_10818 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/10818
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int min = 1_000_000;
		int max = -1_000_000;
		int tmp = 0;
		for(int i = 0; i < N; i++) {
			tmp = sc.nextInt();
			
			if(tmp < min) min = tmp;
			if(tmp > max) max = tmp;
		}
		
		System.out.println(min + " " + max);
		sc.close();
	}
}

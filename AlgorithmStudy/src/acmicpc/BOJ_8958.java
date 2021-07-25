package acmicpc;

import java.util.Scanner;

public class BOJ_8958 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/8958
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] res = new int[T];
		
		for(int i = 0; i < T; i++) {
			String str = sc.next();
			
			int sum = 0;
			int score = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'X') {
					score = 0;
				} else {
					score++;
					sum += score;
				}
			}
			res[i] = sum;
		}
		
		for(int s : res) System.out.println(s);
		
		sc.close();
	}
}

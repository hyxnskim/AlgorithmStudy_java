package acmicpc;

import java.util.Scanner;

public class BOJ_5692 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/5692
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int factorial(int num) {
		int result = 1;
		
		for(int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
	
	public static int cal(int num) {
		int result = 0;
		int idx = 1;
		
		while(num > 0) {
			result += (num%10) * factorial(idx++);
			num /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(true) {
			num = sc.nextInt();
			if(num == 0) break;
			System.out.println(cal(num));
		}
		sc.close();
	}
}

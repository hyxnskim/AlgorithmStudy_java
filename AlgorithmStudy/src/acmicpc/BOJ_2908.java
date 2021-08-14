package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2908
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = reverse(sc.nextInt());
		int b = reverse(sc.nextInt());
		
		if(a > b) System.out.println(a);
		else System.out.println(b);
		
		sc.close();
	}
	
	public static int reverse(int n) {
		int res = 0;
		
		while(n >= 1) {
			res = res*10 + n%10;
			n /= 10;
		}
		
		return res;
	}

}

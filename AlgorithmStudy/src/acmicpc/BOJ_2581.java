/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2581
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2581 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0, min = -1;
		for(int i = N; i >= M; i--) {
			if(isPrime(i)) {
				sum += i;
				min = i;
			}
		}
		
		if(min == -1) System.out.println(-1);
		else System.out.println(sum + "\n" + min);
		
		
		sc.close();
		
	}
	
	static boolean isPrime(int n) {
		
		for(int i = 2; i <= n/2; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}

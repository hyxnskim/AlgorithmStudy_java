/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/9020
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_9020 {
	
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			solution();
		}
		
		sc.close();
	}
	
	static void solution() {
		int n = N / 2;
		int i = n;
		for(; i > 2; i++) {
			if(!isPrime(i) || !isPrime(N-i)) continue;
			else break;
		}
		
		if(i > N-i) System.out.printf("%d %d\n", N-i, i);
		else System.out.printf("%d %d\n", i, N-i);
	}
	
	static boolean isPrime(int n) {
		int l = (int)Math.sqrt(n);
		for(int i = 2; i <= l; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}

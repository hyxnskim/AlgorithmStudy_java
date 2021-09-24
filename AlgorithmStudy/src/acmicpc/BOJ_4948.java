/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/4948
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N;
		while((N = sc.nextInt()) != 0) {
			int cnt = 0;
			for(int i = N+1; i <= N*2; i++)
				if(isPrime(i)) cnt++;
			System.out.println(cnt);
		}
		
		sc.close();
	}
	
	static boolean isPrime(int n) {
		if(n <= 1) return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}

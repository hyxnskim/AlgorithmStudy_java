/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/11653
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_11653 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(isPrime(N)) System.out.println(N);
		else if(N == 1);
		else {
			
			for(int i = 2; i <= N; i++) {
				if(!isPrime(i) || N%i != 0) continue;
				
				while(N >= i && N%i == 0) {
					System.out.println(i);
					N /= i;
				}
			}
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

package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2839
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(solution(N));

		sc.close();
	}
	
	static int solution(int N) {
		int a = N / 5;
		if(a == 0 && N % 3 != 0) return -1;
		
		for(int i = a; i >= 0; i--) {
			if((N - 5*i) % 3 == 0) 
				return i + ((N - 5*i) / 3);  
		}
		return -1;
	}

}

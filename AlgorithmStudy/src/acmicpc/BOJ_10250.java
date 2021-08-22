package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10250
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_10250 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			System.out.println(findRoom(H, W, N));
		}
		
		sc.close();
	}
	
	public static int findRoom(int H, int W, int N) {
		
		int height = 0, ho = 0;
		if(N % H == 0) {
			ho = N / H;
			height = H;
		}
		else {
			ho = N / H + 1;
			height = N % H;
		}
		
		return height * 100 + ho;
	}
}

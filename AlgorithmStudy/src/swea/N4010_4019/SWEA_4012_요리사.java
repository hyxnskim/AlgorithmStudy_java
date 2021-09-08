package swea.N4010_4019;

/**
 * <pre>
 * My solution for SWEA_4012
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */


import java.util.Scanner;

public class SWEA_4012_요리사 {
	
	static int N;
	static int[][] S;
	static int[] ori, com;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			S = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = sc.nextInt();
					S[i][j] = tmp;
				}
			}
			
			ori = new int[N];
			for(int i = 0; i < N; i++) ori[i] = i+1;
			com = new int[N/2];
			
			min = Integer.MAX_VALUE;
			comb(N, N/2);
			
			System.out.printf("#%d %d\n", t+1, min);
		}
		sc.close();
	}
	
	public static void comb(int n, int r) {
		if (r == 0) cal();
		else if (n < r) return;
		else
		{
			com[r - 1] = ori[n - 1];
			comb(n - 1, r - 1);
			comb(n - 1, r);
		}
	}
	
	public static void cal() {
		int[] rest = new int[N/2];
		int[] ori2 = ori.clone();
		for(int i = 0; i < N/2; i++) {
			ori2[com[i]-1] = -1;
		}
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(ori2[i] != -1) rest[idx++] = i + 1;
		}
		
		int A = 0, B = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				A += S[com[i]-1][com[j]-1];
				B += S[rest[i]-1][rest[j]-1];
			}
		}

		int diff = Math.abs(A - B);
		if(diff < min) min = diff;
	}
}
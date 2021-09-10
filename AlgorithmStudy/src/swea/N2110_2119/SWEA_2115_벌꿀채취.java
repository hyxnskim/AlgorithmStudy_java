package swea.N2110_2119;

/**
 * <pre>
 * My solution for SWEA_2115
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {
	
	static int N, M, C;
	static int[] mat;
	static int[] A, B;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			mat = new int[N*N];
			for(int i = 0; i < N*N; i++) {
				mat[i] = sc.nextInt();
			}
			
			A = new int[M];
			B = new int[M];
			
			max = Integer.MIN_VALUE;
			solution();
			
			System.out.printf("#%d %d\n", t+1, max);
		}
		
		sc.close();
	}
	
	static void solution() {
		int res;
		
		for(int i = 0; i < N*N - M; i++) {
			if(i/N == (i+M-1)/N) {	// 같은 row에 있다면
				// A 먼저 구하기
				int idx = 0;
				for(int j = i; j <= i+M-1; j++) A[idx++] = mat[j];
				
				for(int j = i+M; j <= N*N - M; j++) {
					if(j/N == (j+M-1)/N) {
						// B 구하기
						idx = 0;
						for(int k = j; k <= j+M-1; k++) B[idx++] = mat[k];
						
						res = cal(A) + cal(B);
						if(res > max) max = res;
						
					}
				}
			}
		}
	}
	
	static int cal(int[] arr) {
		int sum, res;
		int tmpMax = 0;
		
		for(int i = 1; i < 1<<M; i++) {
			sum = 0; res = 0;
			for(int j = 0; j < M; j++) {
				if((i & (1<<j)) != 0) sum += arr[j];
			}

			if(sum <= C) {
				for(int j = 0; j < M; j++) {
					if((i&(1<<j)) != 0) {
						res += arr[j] * arr[j];
					}
				}
				if(res > tmpMax) tmpMax = res;
			}
		}
		return tmpMax;
	}
}
/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2798
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		boolean flag = false;
		int max = 0;
		Loop:
		for(int i = 0; i < N; i++){
			for(int j = i+1; j < N; j ++){
				for(int k = j+1; k < N; k++){
					int tmp = arr[i] + arr[j] + arr[k];
					if(tmp == M) {
						flag = true;
						break Loop;
					}
					if(tmp < M && tmp > max) max = tmp;
					if(tmp > M) break;
				}
			}
		}

		if(flag) System.out.println(M);
		else System.out.println(max);
	}
}

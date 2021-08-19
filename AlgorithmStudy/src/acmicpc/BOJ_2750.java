package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2750
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N-1; i++) {
			int min = i;
			int j = i+1;
			for(; j < N; j++) {
				if(arr[j] < arr[min]) min = j;
			}
			if(min != i) {
				int tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
		}
		
		for(int i = 0; i < N; i++) System.out.println(arr[i]);
		
		sc.close();
	}

}

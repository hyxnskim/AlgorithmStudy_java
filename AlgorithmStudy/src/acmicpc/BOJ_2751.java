package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2751
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_2751 {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int[] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
	
		merge_sort(list, 0, N);
		
		for(int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
		
		sc.close();
	}
	
	public static void merge_sort(int list[], int left, int right) {
		if(right - left > 1) {
			int mid = (left + right) / 2;
			merge_sort(list, left, mid);
			merge_sort(list, mid, right);
			merge(list, left, mid, right);
		}
	}
	
	public static void merge(int list[], int left, int mid, int right) {
		int[] tmp = new int[N];
		int i = left, j = mid;
		int idx = left;
		
		while(i < mid && j < right) {
			if(list[i] < list[j]) {
				tmp[idx++] = list[i++];
			} else {
				tmp[idx++] = list[j++];
			}
		}
		
		while(i < mid) {
			tmp[idx++] = list[i++];
		}
		while(j < right) {
			tmp[idx++] = list[j++];
		}
		
		for(i = left; i < right; i++) {
			list[i] = tmp[i];
		}
	}
}

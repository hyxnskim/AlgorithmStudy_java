package week2_search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10816
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class NumberCard2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N; // 상근이가 가지고 있는 숫자 카드의 개수
		ArrayList<Integer> have = new ArrayList<Integer>();
		
		int M = 8; // 주어지는 정수의 개수
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			have.add(sc.nextInt());
		}
		
		M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			nums.add(sc.nextInt());
		}
		
		int cnt = 0, num = 0;
		for(int i = 0; i < M; i++) {
			cnt = 0;
			num = nums.get(i);
			for(int j = 0; j < N; j++) {
				if(have.get(j) == num) cnt++;
			}
			System.out.print(cnt + " ");
		}
	}
}

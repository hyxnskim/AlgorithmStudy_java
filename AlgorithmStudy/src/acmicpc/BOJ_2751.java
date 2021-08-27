package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2751
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		list.sort(null);
		
		for(int i = 0; i < N; i++) {
			System.out.println(list.get(i));
		}
		
		sc.close();
	}
}

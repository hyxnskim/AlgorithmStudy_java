package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1085
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		if(x < min) min = x;
		if(y < min) min = y;
		if(w - x < min) min = w - x;
		if(h - y < min) min = h - y;
		
		System.out.println(min);
		
		sc.close();

	}

}

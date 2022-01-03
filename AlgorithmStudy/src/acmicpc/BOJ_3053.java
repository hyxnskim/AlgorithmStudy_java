/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/3053
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_3053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		double e_circle = r*r*Math.PI;
		double t_circle = r*r*2;
		
		System.out.printf("%.6f\n%.6f", e_circle, t_circle);

		sc.close();
	}
}

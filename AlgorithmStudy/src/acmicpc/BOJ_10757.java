package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10757
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		
		sc.close();
	}

}

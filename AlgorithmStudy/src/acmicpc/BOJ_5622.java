package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/5622
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int tot = 0;
		for(char c : str.toCharArray()) {
			if(c == 'A' || c == 'B' || c == 'C') tot += 3; 
			else if(c == 'D' || c == 'E' || c == 'F') tot += 4; 
			else if(c == 'G' || c == 'H' || c == 'I') tot += 5; 
			else if(c == 'J' || c == 'K' || c == 'L') tot += 6; 
			else if(c == 'M' || c == 'N' || c == 'O') tot += 7; 
			else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S') tot += 8; 
			else if(c == 'T' || c == 'U' || c == 'V') tot += 9; 
			else if(c == 'W' || c == 'X' || c == 'Y' || c == 'Z') tot += 10; 
		}
		System.out.println(tot);
		
		sc.close();
	}

}

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/4153
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_4153 {
	 static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = new int[3];
		
		while(true) {
			String[] str = sc.nextLine().split(" ");
			
			int cnt = 0;
			for(int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(str[i]);
				if(num[i] == 0) cnt++;
			}
			
			if(cnt == 3) break;
			else if(cnt > 0) System.out.println("wrong");
			else solution();
			
		}
		
		sc.close();
	}
	
	static void solution() {
		
		for(int i = 0; i < 3; i++) {
			num[i] *= num[i];
		}
		
		if(num[0] + num[1] == num[2] || num[0] + num[2] == num[1]
				|| num[1] + num[2] == num[0]) System.out.println("right");
		else System.out.println("wrong");
	}
}

package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2941
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */


import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		
		int cnt = 0;
		for(int i = 0; i < len; i++) {
			char c = str.charAt(i);
			
			if(c == 'c') {
				if(i+1 < len && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) i++;
			} else if(c == 'd') {
				if(i+2 < len && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') i += 2;
				else if(i+1 < len && str.charAt(i+1) == '-') i++;
			} else if((c == 'l' || c == 'n') && i+1 < len && str.charAt(i+1) == 'j') {
				i++;
			} else if((c == 's' || c =='z') && i+1 < len && str.charAt(i+1) == '=' ) {
				i++;
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}

}

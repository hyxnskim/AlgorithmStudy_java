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
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == 'c') {
				if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-') i++;
			} else if(c == 'd') {
				if(str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') i += 2;
				else if(str.charAt(i+1) == '-') i++;
			} else if((c == 'l' || c == 'n') && str.charAt(i+1) == 'j') {
				i++;
			} else if((c == 's' || c =='z') && str.charAt(i+1) == '=' ) {
				i++;
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}

}

package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1234_비밀번호 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1234
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE&problemTitle=1234&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		String[] res = new String[T];
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			res[t] = getPw(sc.next());
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %s\n", t+1, res[t]);
		}
		sc.close();
	}
	
	public static String getPw(String str) {
		Stack<Character> stack = new Stack<>();
		char c;
		
		for(int i = str.length() - 1; i >=0; i--) {
			c = str.charAt(i);
			if(stack.isEmpty()) stack.add(c);
			else {
				if(stack.peek() == c) stack.pop();
				else stack.push(c);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		return sb.toString();
	}
}

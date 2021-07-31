package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1218
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  10;
		int[] res = new int[10];
		
		for(int t = 0; t < T; t++) {
			int len = sc.nextInt();
			String str = sc.next();
			
			Stack<Character> stack = new Stack<>();
			
			loop :
			for(int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[' || c == '{' || c == '<') {
					stack.add(c);
				} else if(c == ')') {
					if(stack.peek() == '(') stack.pop();
					else break loop;
				} else if(c == ']') {
					if(stack.peek() == '[') stack.pop();
					else break loop;
				} else if(c == '}') {
					if(stack.peek() == '{') stack.pop();
					else break loop;
				} else if(c == '>') {
					if(stack.peek() == '<') stack.pop();
					else break loop;
				}
			}
			
			res[t] = stack.isEmpty() ? 1 : 0;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		
		sc.close();
	}
}

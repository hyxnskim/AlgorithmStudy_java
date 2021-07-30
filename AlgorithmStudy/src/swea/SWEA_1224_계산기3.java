package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_계산기3 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1224
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14tDX6AFgCFAYD&categoryId=AV14tDX6AFgCFAYD&categoryType=CODE&problemTitle=1224&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			String tmp = sc.next();
			
			// 입력 문자열 후위 표기법으로 바꾸기
			String post = toPostfix(tmp);
			res[t] = calPostfix(post);
			
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		sc.close();
	}
	
	public static String toPostfix(String str) {
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= '0' && c <= '9') {
				sb.append(c);
			} else if(c == '+') {
				if(stack.isEmpty()) stack.push(c);
				else {
					while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '+')) {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
				
			} else if(c == '*' || c == '(') {
				stack.push(c);
				
			} else if(c == ')') {
				char t;
				while((t = stack.pop()) != '(') {
					sb.append(t);
				}
			}
		} // end for
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static int calPostfix(String str) {
		Stack<Integer> stack = new Stack<>();
		char c;
		int n, m;
		
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(c >= '0' && c <= '9') stack.push(Integer.parseInt(c + ""));
			else {
				n = stack.pop();
				m = stack.pop();
				
				if(c == '+') stack.push(n + m);
				else if(c == '*') stack.push(n * m);
			}
		}
		return stack.pop();
	}
}

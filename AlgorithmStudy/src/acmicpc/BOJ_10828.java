package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/10828
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_10828 {
	
	static int[] stack;
	static int s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		stack = new int[N+1];
		s = 0;
		
		for(int i = 0; i < N; i++) {
			String[] arr = sc.nextLine().split(" ");
			
			switch(arr[0]) {
			case "push":
				push(Integer.parseInt(arr[1]));
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;
			default:
				System.out.println("Input Error");
			}
		}
		sc.close();
	}
	
	static void push(int n) {
		stack[++s] = n;
	}
	
	static void pop() {
		if(s <= 0) System.out.println(-1);
		else System.out.println(stack[s--]);
	}
	
	static void size() {
		System.out.println(s);
	}
	
	static void empty() {
		if(s <= 0) System.out.println(1);
		else System.out.println(0);
	}
	
	static void top() {
		if(s <= 0) System.out.println(-1);
		else System.out.println(stack[s]);
	}

}

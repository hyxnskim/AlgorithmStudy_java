package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1238_Contact {
	
	/**
	 * <pre>
	 * My solution for SWEA_1238
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static Node[] nodes;
	public static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			nodes = new Node[N + 1];
			stack = new Stack<>();
			
			for(int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				String[] arr = str.split(" ");
				
				int l = 0, r = 0;
				if(arr.length > 2) l = Integer.parseInt(arr[2] + "");
				if(arr.length > 3) r = Integer.parseInt(arr[3] + "");
				
				nodes[Integer.parseInt(arr[0] + "")] = new Node(arr[1], l, r);
			}
			
			postorder_traverse(1);
			System.out.printf("#%d %d\n", t+1, stack.pop());
		}
		sc.close();
	}
	
	public static void postorder_traverse(int now) {
		if(nodes[now] == null) return;
		postorder_traverse(nodes[now].left);
		postorder_traverse(nodes[now].right);
		process_node(nodes[now].c);
	}
	
	public static void process_node(String str) {
		int a = 0, b = 0;
		if(str.equals("+")) {
			stack.add(stack.pop() + stack.pop());
		} else if(str.equals("-")) {
			a = stack.pop();
			b = stack.pop();
			stack.add(b - a);
		} else if(str.equals("*")) {
			stack.add(stack.pop() * stack.pop());
		} else if(str.equals("/")) {
			a = stack.pop();
			b = stack.pop();
			stack.add(b / a);
		} else {
			stack.add(Integer.parseInt(str));
		}
	}
}

class Node {
	String c;
	int left, right;
	
	Node(String c, int left, int right){
		this.c = c;
		this.left = left;
		this.right = right;
	}
}

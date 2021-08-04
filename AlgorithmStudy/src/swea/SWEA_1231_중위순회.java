package swea;

import java.util.Scanner;

public class SWEA_1231_중위순회 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1231
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD&categoryId=AV140YnqAIECFAYD&categoryType=CODE&problemTitle=1231&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static Node[] nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			nodes = new Node[N + 1];
			
			for(int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				String[] arr = str.split(" ");
				
				int l = 0, r = 0;
				if(arr.length > 2) l = Integer.parseInt(arr[2] + "");
				if(arr.length > 3) r = Integer.parseInt(arr[3] + "");
				
				nodes[Integer.parseInt(arr[0] + "")] = new Node(arr[1].charAt(0), l, r);
			}
			
			System.out.printf("#%d ", t+1);
			inorder_traverse(1);
			System.out.println();
		}

		sc.close();
	}
	
	public static void inorder_traverse(int now) {
		if(nodes[now] == null) return;
		inorder_traverse(nodes[now].left);
		System.out.print(nodes[now].c);
		inorder_traverse(nodes[now].right);
	}
}

class Node {
	char c;
	int left, right;
	
	Node(char c, int left, int right){
		this.c = c;
		this.left = left;
		this.right = right;
	}
}
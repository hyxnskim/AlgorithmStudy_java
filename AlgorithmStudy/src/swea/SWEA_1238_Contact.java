package swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


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
	
	public static boolean[][] map;
	public static boolean[] isVisited;
	public static Queue<Node> queue;
	public static int depth_max;
	public static ArrayList<Node> list;
	public static int S = 101;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int t = 0; t < T; t++) {
			int len = sc.nextInt();
			int start = sc.nextInt();
			
			map = new boolean[S][S];
			isVisited = new boolean[S];
			queue = new LinkedList<>();
			list = new ArrayList<>();
			depth_max = 0;
			
			for(int i = 0; i < len/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				map[from][to] = true;
			}
			
			Node now = new Node(start, 1);
			bfs(now);
			
			int max = -1;
			for(Node n : list) {
				if(n.depth == depth_max && n.n > max) {
					max = n.n;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, max);
		}
		sc.close();
	}
	
	public static void bfs(Node now) {
		queue.add(now);
		isVisited[now.n] = true;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			for(int i = 0; i < S; i++) {
				if(map[tmp.n][i] && !isVisited[i]) {
					int d = tmp.depth + 1;
					if(d > depth_max) depth_max = d;
					
					Node node = new Node(i, d);
					queue.add(node);
					list.add(node);
					isVisited[i] = true;
				}
			}
		}
	}
}

class Node{
	int n;
	int depth;
	
	Node(int n, int depth){
		this.n = n;
		this.depth = depth;
	}
}
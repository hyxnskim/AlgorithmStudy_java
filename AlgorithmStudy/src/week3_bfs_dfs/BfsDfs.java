package week3_bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
	
	int num;
	boolean visited = false;
	ArrayList<Integer> connected = new ArrayList<Integer>();
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public ArrayList<Integer> getConnected() {
		return connected;
	}
	public void setConnected(ArrayList<Integer> connected) {
		this.connected = connected;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [num=" + num + ", visited=" + visited + ", connected=" + connected + "]";
	}
}

public class BfsDfs {

	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/1260
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static ArrayList<Node> nodes = new ArrayList<Node>();
	public static Node start = new Node();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 정점의 개수
		int M = sc.nextInt();	// 간선의 개수
		int V = sc.nextInt();	// 탐색을 시작할 정점의 번호
		
		if(M==0) {
			Node n = new Node();
			n.setNum(N);
			nodes.add(n);
		}
		
		// 1. 노드 생성
		for(int i = 0; i < M; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			
			Node n1 = findNode(t1);
			Node n2 = findNode(t2);
			
			if(n1 == null) {
				Node newNode1 = new Node();
				newNode1.setNum(t1) ;
				newNode1.getConnected().add(t2);
				nodes.add(newNode1);
			} else {
				n1.getConnected().add(t2);
			}
			
			if(n2 == null) {
				Node newNode = new Node();
				newNode.setNum(t2) ;
				newNode.getConnected().add(t1);
				nodes.add(newNode);
			} else {
				n2.getConnected().add(t1);
			}
		}
		
		for(int i = 0; i < nodes.size(); i++) {
			ArrayList<Integer> tmp = nodes.get(i).getConnected();
			Collections.sort(tmp);
			Collections.reverse(tmp);
			nodes.get(i).setConnected(tmp);
		}
//		for(int i = 0; i < nodes.size(); i++) {
//			System.out.println(nodes.get(i));
//		}
		
		start = findNode(V);
		
		// 2. DFS
		dfs();
		System.out.println();
		
		for(int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setVisited(false);
		}
		for(int i = 0; i < nodes.size(); i++) {
			ArrayList<Integer> tmp = nodes.get(i).getConnected();
			Collections.sort(tmp);
			nodes.get(i).setConnected(tmp);
		}
		
		// 3. BFS
		bfs();
	}
	
	public static Node findNode(int n) {
		Node node = new Node();
		for(int i = 0; i < nodes.size(); i++) {
			node = nodes.get(i);
			if(node.getNum() == n) return node;
		}
		return null;
	}
	
	public static void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		
		Node now = start;
		if(now == null) return;
		System.out.print(now.getNum() + " ");
		now.setVisited(true);
		for(int i = 0; i < now.getConnected().size(); i++) {
			stack.push(now.getConnected().get(i));
		}
		
		while(!stack.isEmpty()) {
			now = findNode(stack.pop());
			if(now.isVisited()) continue;
			
			System.out.print(now.getNum() + " ");
			now.setVisited(true);
			
			Node next = new Node();
			for(int i = 0; i < now.getConnected().size(); i++) {
				next = findNode(now.getConnected().get(i));
				if(next.isVisited()) continue;
				stack.push(next.getNum());
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Node now = start;
		if(now == null) return;
		System.out.print(now.getNum() + " ");
		now.setVisited(true);
		for(int i = 0; i < now.getConnected().size(); i++) {
			queue.add(now.getConnected().get(i));
		}
		
		while(!queue.isEmpty()) {
			now = findNode(queue.poll());
			if(now.isVisited()) continue;
			
			System.out.print(now.getNum() + " ");
			now.setVisited(true);
			
			Node next = new Node();
			for(int i = 0; i < now.getConnected().size(); i++) {
				next = findNode(now.getConnected().get(i));
				if(next.isVisited()) continue;
				queue.add(next.getNum());
			}
		}
	}
}

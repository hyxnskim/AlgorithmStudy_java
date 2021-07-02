package week3_bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
				Node newNode = new Node();
				newNode.setNum(t1) ;
				newNode.getConnected().add(t2);
				nodes.add(newNode);
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
		
//		for(int i = 0; i < nodes.size(); i++) {
//			System.out.println(nodes.get(i));
//		}
		
		start = findNode(V);
		
		// 2. DFS
		dfs(start);
		System.out.println();
		
		for(int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setVisited(false);
		}
		
		// 3. BFS
		bfs();
		
		sc.close();
	}
	
	public static Node findNode(int n) {
		Node node = new Node();
		for(int i = 0; i < nodes.size(); i++) {
			node = nodes.get(i);
			if(node.getNum() == n) return node;
		}
		return null;
	}
	
	public static Node getMinNode(ArrayList<Integer> connected) {
		ArrayList<Integer> tmp = connected;
		
		for(int i = 0; i < connected.size(); i++) {
			Collections.sort(tmp);
		}
		
		Node node = new Node();
		for(int i = 0; i < tmp.size(); i++) {
			node = findNode(tmp.get(i));
			if(!node.isVisited()) {
				return node;
			}
		}
		return null;
	}
	
	public static void dfs(Node start) {
		start.setVisited(true);
		System.out.print(start.getNum() + " ");
		
		for(int i = 0; i < start.getConnected().size(); i++) {
			Node now = getMinNode(start.getConnected());
			if(now == null) break;
			if(!now.isVisited()) {
				dfs(now);
			}
		}
	}
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		
		Node now = start;
		if(now == null) return;
		
		System.out.print(now.getNum() + " ");
		now.setVisited(true);
		for(int i = 0; i < now.getConnected().size(); i++) {
			queue.add(findNode(now.getConnected().get(i)));
		}
		
		while(!queue.isEmpty()) {
			now = queue.poll();
			if(now.isVisited()) continue;
			
			System.out.print(now.getNum() + " ");
			now.setVisited(true);
			
			Node next = new Node();
			for(int i = 0; i < now.getConnected().size(); i++) {
				next = findNode(now.getConnected().get(i));
				if(next.isVisited()) continue;
				queue.add(next);
			}
		}
	}
}

package swea.N1250_1259;

/**
 * <pre>
 * My solution for SWEA_1251
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1251_하나로 {
	
	static int N;		// 섬의 개수
	static Node[] nodes;// 섬들의 배열
	static double E;	// 환경 부담 세율
	static int[] parent;// 각 노드의 부모
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			nodes = new Node[N];
			parent = new int[N];
			
			for(int i = 0; i < N; i++) nodes[i] = new Node(sc.nextInt(), 0, 0);
			for(int i = 0; i < N; i++) nodes[i].y = sc.nextInt();
			
			E = sc.nextDouble();
			
			ArrayList<Node> distance = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					distance.add(new Node(i, j, calDistance(nodes[i].x, nodes[i].y, nodes[j].x, nodes[j].y)));
				}
			}
			
			Collections.sort(distance, new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
					if(n1.dis < n2.dis) return -1;
					else if(n1.dis > n2.dis) return 1;
					else return 0;
				}
			});
			
			for(int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			double res = 0;
			int n1, n2;
			for(int i = 0; i < distance.size(); i++) {
				n1 = distance.get(i).x;
				n2 = distance.get(i).y;
				if(findParent(n1) != findParent(n2)) {
					union(n1, n2);
					res+= distance.get(i).dis;
				}
			}
			
			System.out.printf("#%d %.0f\n", t+1, res);
		}
		sc.close();
	}
	
	public static double calDistance(int x1, int y1, int x2, int y2) {
		return E * (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	public static int findParent(int n) {
		if(parent[n] == n) return n;
		else return parent[n] = findParent(parent[n]);
	}
	
	public static void union(int n1, int n2) {
		n1 = findParent(n1);
		n2 = findParent(n2);
		
		if(n1 != n2) parent[n2] = n1;
	}
}

class Node{
	int x, y;
	double dis;
	Node(int x, int y, double dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}

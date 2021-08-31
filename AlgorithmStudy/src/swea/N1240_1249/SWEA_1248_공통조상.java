package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1248
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */


import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1248_공통조상 {
	static int V, E;
	static int[][] tree;
	static int[] ancestor;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			tree = new int[V+1][3];
			ancestor = new int[V+1];
			
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			int p, c;
			for(int i = 0; i < E; i++) {
				p = sc.nextInt();
				c = sc.nextInt();
				tree[p][++tree[p][0]] = c;
				ancestor[c] = p;
			}
			
			int common = findCommon(getAncestors(v1), getAncestors(v2));
			System.out.printf("#%d %d %d\n", t+1, common, (getSubTreeSize(common)+1));
		}
		sc.close();
	}
	
	public static ArrayList<Integer> getAncestors(int vertex){
		ArrayList<Integer> list = new ArrayList<>();
		int next;
		do {
			next = ancestor[vertex];
			list.add(next);
			vertex = next;
		} while(next != 0);
		
		return list;
	}
	
	public static int findCommon(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		for(int i = 0; i < al1.size(); i++) {
			int tmp = al1.get(i);
			for(int j = 0; j < al2.size(); j++) {
				if(tmp == al2.get(j)) return tmp;
			}
		}
		return 0;
	}
	
	public static int getSubTreeSize(int root) {
		int cnt = tree[root][0];
		if(tree[root][0] == 0) return 0;
		
		cnt += getSubTreeSize(tree[root][1]);
		if(tree[root][0] == 2) cnt += getSubTreeSize(tree[root][2]);
		
		return cnt;
	}
}

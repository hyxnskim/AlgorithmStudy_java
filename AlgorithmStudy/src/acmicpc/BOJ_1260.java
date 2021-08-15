package acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/1260
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	 static ArrayList<Integer>[] connected;
	 static boolean[] isVisited;

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 int M = sc.nextInt();
		 int V = sc.nextInt();

		 connected = new ArrayList[N + 1];

		 for(int i = 1; i < N + 1; i++) {
			 connected[i] = new ArrayList<Integer>();
		 }

		 // 1. 노드 생성
		 for(int i = 0; i < M; i++) {
			 int t1 = sc.nextInt();
			 int t2 = sc.nextInt();

			 connected[t1].add(t2);
			 connected[t2].add(t1);
		 }
        
		 for(int i = 1; i < N + 1; i++) {
			 Collections.sort(connected[i]);
		 }
        
		 // 2. dfs
		 isVisited = new boolean[N + 1];
		 dfs(V);
		 System.out.println();

		 // 3. bfs
		 isVisited = new boolean[N + 1];
		 bfs(V);
		 System.out.println();

		 sc.close();
    }

    private static void dfs(int now) {
        if(isVisited[now]) {
            return;
        }

        isVisited[now] = true;
        System.out.print(now + " ");
        for(int next : connected[now]) {
            if(!isVisited[next])
                dfs(next);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(start);
        isVisited[start] = true;

        int now;
        while(!queue.isEmpty()) {
            now = queue.poll();
            System.out.print(now + " ");
            
            for(int next : connected[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}

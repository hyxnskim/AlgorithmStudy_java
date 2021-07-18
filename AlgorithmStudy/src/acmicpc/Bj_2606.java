package acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bj_2606 {

	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/2606
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	static ArrayList<Integer>[] connected;
	static boolean[] isVisited;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 컴퓨터의 수
		int M = sc.nextInt();	// 컴퓨터 쌍
		
		connected = new ArrayList[N + 1];

		for(int i = 1; i < N + 1; i++) {
			connected[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < M; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();

			connected[t1].add(t2);
			connected[t2].add(t1);
		}
       
		for(int i = 1; i < N + 1; i++) {
			 Collections.sort(connected[i]);
		}
		 
		isVisited = new boolean[N + 1];
		dfs(1);
		System.out.println(cnt-1);

		sc.close();
	}
	
	 private static void dfs(int now) {
        if(isVisited[now]) {
            return;
        }

        isVisited[now] = true;
        cnt++;
        for(int next : connected[now]) {
            if(!isVisited[next])
                dfs(next);
        }
    }
}

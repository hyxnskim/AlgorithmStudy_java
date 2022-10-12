package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung_2020_sf_am_1 {
	
	static int n, k;
	static int cnt = 0, ans = 0;
	static int[] rail;
	static boolean[] occupied;
	static int front = 1, back;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		back = n;
		rail = new int[n*2+1];
		occupied = new boolean[n*2+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n*2; i++) {
			rail[i] = Integer.parseInt(st.nextToken());
		}
		
		while(cnt < k) {
			ans++;
			
			// 1. 무빙워크 한 칸 회전
			front--; back--;
			if(front == 0) front = n*2;
			if(back == 0) back = n*2;
//			System.out.println("front = " + front + ", back = " + back);
			
			// 2. 사람 이동
			if(front > back) {
				for(int i = front; i <= n*2; i++) {
					if(occupied[i]) move(i);
				}
				for(int i = 1; i <= back; i++) {
					if(occupied[i]) move(i);
				}
			} else {
				for(int i = front; i <= back; i++) {
					if(occupied[i]) move(i);
				}
			}
			
			// 3. 1번 칸에 사람이 없고 안정성이 0이 아니라면 사람 한 명 더 올리기
			if(!occupied[front] && rail[front] > 0) {
				occupied[front] = true;
				if(--rail[front] == 0) cnt++;
			}
			
//			for(int i = 1; i <= n*2; i++) System.out.print(rail[i] + " ");
//			System.out.println();
//			for(boolean b : occupied) {
//				if(b) System.out.print("o ");
//				else System.out.print("_ ");
//			}
//			System.out.println("\n----------------------------------");
			
		}
		
		System.out.println(ans);
	}
	
	public static void move(int idx) {
		int nextIdx = (idx+1) % (n*2);
		if(nextIdx == 0) nextIdx = n*2;
		
		if(!occupied[nextIdx] && rail[nextIdx] > 0) {
			occupied[nextIdx] = true;
			occupied[idx] = false;
			if(--rail[nextIdx] == 0) cnt++;
			
			if(nextIdx == back) {
				occupied[nextIdx] = false;
			}
		}
	}

}

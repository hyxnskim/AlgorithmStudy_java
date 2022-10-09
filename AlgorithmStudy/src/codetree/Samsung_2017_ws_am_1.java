package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung_2017_ws_am_1 {
	
	static int n;
	static int max = 0;
	static int[][] work;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		work = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solution(0, 0);
		System.out.println(max);
	}
	
	public static void solution(int idx, int price) {
		
		if(idx >= n) {
			if(price > max) max = price;
			return;
		}
		
		int nidx = idx + work[idx][0];
		if(nidx <= n) {
			solution(nidx, price + work[idx][1]);
		}
		solution(idx + 1, price);
	}

}

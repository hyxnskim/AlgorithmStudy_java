package codetree;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Samsung_2015_ws_1 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = Integer.parseInt(br.readLine());	// 식당 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cust = new int[res];	//각 식당의 손님 수
		for(int i = 0; i < res; i++) {
			cust[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 팀장이 검사할수 있는 사람 수
		int m = Integer.parseInt(st.nextToken());	// 팀원이 검사할 수 있는 사람 수

		long answer = res;
		
		for(int i = 0; i < res; i++) {
			int tmp = cust[i] - n;
			
			if(tmp <= 0) continue;
			else if(tmp % m == 0) answer += tmp/m;
			else answer += (tmp/m) + 1;
		}
		
		System.out.println(answer);
	}

}

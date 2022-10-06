package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_24416 {
	
	static int cnt_dp = 0;
	static int cnt_rec = 0;
	static int[] dp_arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp_arr = new int[N+1];
		
		recursive(N);
		dynamic(N); // 사실 dp 결과는 항상 N-2라 이거 안돌려도 되긴 함
		
		System.out.println(cnt_rec + " " + cnt_dp);
	}
	
	static int recursive(int n) {
		
		if(n == 1 || n == 2) {
			cnt_rec++;
			return 1;
		}
		else return (recursive(n-1) + recursive(n-2));
	}
	
	static void dynamic(int n) {
		
		dp_arr[1] = dp_arr[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			cnt_dp++;
			dp_arr[i] = dp_arr[i-1] + dp_arr[i-2];
		}
		
	}

}

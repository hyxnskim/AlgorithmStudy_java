package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung_2017_sf_pm_2 {
	
	static int n;
	static int[] arr, op;
	static int max, min;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		op = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		solution(1, arr[0]);
		
		System.out.println(min + " " + max);
		
	}
	
	public static void solution(int idx, int val) {
		
		if(idx >= n) {
			if(val > max) max = val;
			if(val < min) min = val;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) solution(idx+1, val+arr[idx]);
				if(i == 1) solution(idx+1, val-arr[idx]);
				if(i == 2) solution(idx+1, val*arr[idx]);
				op[i]++;
			}
		}
		
	}

}

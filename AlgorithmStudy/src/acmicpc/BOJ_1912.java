package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	
	static int[] arr, sum;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sum = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sum[0] = arr[0];
		for(int i = 1; i < N; i++) {
			if(sum[i-1] + arr[i] > arr[i]) sum[i] = sum[i-1] + arr[i];
			else sum[i] = arr[i];
		}
		
		int max = sum[0];
		for(int i = 1; i < N; i++) {
			if(sum[i] > max) max = sum[i];
		}
		
		System.out.println(max);
		
	}

}

package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13305 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N-1];
		int[] price = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1 ; i++) dis[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < N; i++) {
			if(price[i-1] < price[i]) price[i] = price[i-1];
		}
		
		int res = 0;
		for(int i = 0; i < N-1; i++) {
			res += dis[i] * price[i];
		}
				
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

}

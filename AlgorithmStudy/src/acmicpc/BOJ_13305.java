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
		long[] dis = new long[N-1];
		long[] price = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1 ; i++) dis[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) price[i] = Long.parseLong(st.nextToken());
		
		for(int i = 1; i < N; i++) {
			if(price[i-1] < price[i]) price[i] = price[i-1];
		}
		
		long res = 0;
		for(int i = 0; i < N-1; i++) {
			res += dis[i] * price[i];
		}
				
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

}

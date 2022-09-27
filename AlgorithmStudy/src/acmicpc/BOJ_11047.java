package acmicpc;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class BOJ_11047 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[] changes = new int[N];
		for(int i = 0; i < N; i++) {
			changes[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N-1; i >= 0; i--) {
			if(P >= changes[i]) cnt += P / changes[i];
			P %= changes[i];
		}
		
		bw.write(String.valueOf(cnt));		
		bw.flush();
		bw.close();
	}

}

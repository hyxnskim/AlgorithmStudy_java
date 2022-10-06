package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184 {
	
	static int a, b, c;
	static int[][][] arr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[21][21][21];
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == -1 &&  b == -1 && c == -1) break;
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}
		
	}
	
	static int w(int a, int b, int c) {
		if(inRange(a, b, c) && arr[a][b][c] != 0) return arr[a][b][c];
		
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		if(a > 20 || b > 20 || c > 20) return arr[20][20][20] = w(20, 20, 20);
		
		if(a < b && b < c) {
			return arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) -w(a, b-1, c);
		}
		
		return arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		
	}
	
	static boolean inRange(int a, int b, int c) {
		return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
	}
	
}

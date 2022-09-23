package acmicpc;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class BOJ_1427 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int[] arr = new int[10];
		
		for(int i = 0; i < input.length(); i++) {
			arr[input.charAt(i) - '0']++;
		}
		
		for(int i = 9; i >= 0; i--) {
			for(int j = 0; j < arr[i]; j++) {
				bw.write(String.valueOf(i));
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}

package acmicpc;

/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2751
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2751 {
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
	
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i : list) {
			sb.append(i + "\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
	
}

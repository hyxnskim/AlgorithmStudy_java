package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sorted = Arrays.copyOf(arr, N);
		Arrays.sort(sorted);
		
    // 맵 안쓰면 시간초과됨
		HashMap<Integer, Integer> hm = new HashMap<>();
		int rank = 0;
		for(int i : sorted) {
			if(!hm.containsKey(i)) hm.put(i, rank++);
		}
		
    // StringBuffer로 만들고 한번에 출력하면 더 빠를듯
		for(int i : arr) {
			bw.write(String.valueOf(hm.get(i)) + " ");
		}
		
		bw.flush();
		bw.close();
	}

}

package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15659 {
	
	static int n;
	static int[] arr, op;
	static int max, min, cnt=0;
	static int[] res;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		op = new int[4];
		res = new int[n-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			if(i == 2 || i == 3) cnt += op[i];
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		solution(0);
		
		System.out.println(max + "\n" + min);
		
	}
	
	public static int cal() {
		//덧 뺄 곱 나
		ArrayList<Integer> numList = new ArrayList<>();
		for(int i : arr) numList.add(i);
		
		ArrayList<Integer> op = new ArrayList<>();
		for(int i : res) op.add(i);
		
		for(int i = 0; i < op.size(); i++) {
			if(op.get(i) == 2) {
				numList.set(i, numList.get(i)*numList.get(i+1));
				numList.remove(i+1);
				op.remove(i);
				i--;
			} else if(op.get(i) == 3) {
				numList.set(i, numList.get(i)/numList.get(i+1));
				numList.remove(i+1);
				op.remove(i);
				i--;
			}
		}
		
		int idx = op.size();
		for(int i = 0; i < idx; i++) {
			if(op.isEmpty()) break;
			if(op.get(i) == 0) {
				numList.set(i, numList.get(i)+numList.get(i+1));
				numList.remove(i+1);
				op.remove(i);
				i--;
			} else if(op.get(i) == 1) {
				numList.set(i, numList.get(i)-numList.get(i+1));
				numList.remove(i+1);
				op.remove(i);
				i--;
			}
		}
		
		return numList.get(0);
	}
	
	public static void solution(int idx) {
		
		if(idx >= n-1) {
			int val = cal();
			if(val > max) max = val;
			if(val < min) min = val;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				res[idx] = i;
				solution(idx+1);
				op[i]++;
			}
		}
		
	}


}

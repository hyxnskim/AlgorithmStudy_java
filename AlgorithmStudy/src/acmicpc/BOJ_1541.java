package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1541 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
		
		int N = (st.countTokens()+1) / 2 ;
		int[] nums = new int[N];
		char[] op = new char[N-1];
		
		int cnt_op = 0;
		int cnt_num = 0;
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			if(tmp.equals("+") || tmp.equals("-")) op[cnt_op++] = tmp.charAt(0);
			else nums[cnt_num++] = Integer.parseInt(tmp);
		}
		
		boolean flag = false;
		int res = nums[0];
		for(int i = 0; i < op.length; i++) {
			if(op[i] == '-') flag = true;
			
			if(!flag) res += nums[i+1];
			else res -= nums[i+1];
		}
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		bw.close();
	}

}

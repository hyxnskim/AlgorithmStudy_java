package swea.N1250_1259;

/**
 * <pre>
 * My solution for SWEA_1257
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1257_K번째문자열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int K = sc.nextInt();
			String str = sc.next();
			
			String[] suffixArray = new String[str.length()];
			for(int i = 0; i < str.length(); i++) {
				suffixArray[i] = str.substring(i);
			}
			
			Arrays.sort(suffixArray);
			
			int[] LCP = new int[str.length()];
			LCP[0] = 0;
			int cnt;
			for(int i = 1; i < str.length(); i++) {
				cnt = 0;
				String s1 = suffixArray[i-1];
				String s2 = suffixArray[i];
				
				while(cnt < s1.length() && cnt < s2.length() && s1.charAt(cnt) == s2.charAt(cnt)) cnt++;
				LCP[i] = cnt;
			}
			
			cnt = 0;
			String res = "none";
			for(int i = 0; i < str.length(); i++) {
				cnt += suffixArray[i].length() - LCP[i];
				if(cnt >= K) {
					res = suffixArray[i].substring(0, suffixArray[i].length() - (cnt-K));
					break;
				}
			}
			
			System.out.printf("#%d %s\n", t+1, res);
		}
		sc.close();
	}
}

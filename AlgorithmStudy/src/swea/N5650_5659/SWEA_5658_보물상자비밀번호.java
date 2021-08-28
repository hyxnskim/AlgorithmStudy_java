package swea.N5650_5659;

/**
 * <pre>
 * My solution for SWEA_5658
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호 {
	
	static int N;
	static int len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트 케이스의 수
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();		// 전체 숫자의 개수
			len = N / 4;
			int K = sc.nextInt();	// K번째로 큰 수
	
			String str = sc.next();
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < len; i++) {
				String stmp = rotate(str, i);
				//System.out.println("rotate #" + i + " = " + stmp);
				int[] tmp = calString(stmp);
				for(int j = 0; j < 4; j++) 
					if(!list.contains(tmp[j])) list.add(tmp[j]);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			System.out.printf("#%d %d\n", t+1, list.get(K-1));
		}
		
		sc.close();
	}
	
	public static String rotate(String ori, int move) {
		if(move == 0) return ori;
		
		StringBuffer newString = new StringBuffer();
		String tmp = ori.substring(N - move);
		
		for(int i = 0; i < tmp.length(); i++) {
			newString.append(tmp.charAt(i));
		}
		newString.append(ori.substring(0, N - move));
		
		return newString.toString();
	}
	
	public static int[] calString(String str) {
		int[] arr = new int[4];
		for(int i = 0; i < 4; i++) {
			arr[i] = hexToDec(str.substring(i*len, i*len + len));
			//System.out.println(arr[i]);
		}
		return arr;
	}
	
	public static int hexToDec(String str) {
		int res = 0;
		int t, pow = 1;
		//System.out.print(str + " ");
		for(int i = len-1; i >= 0; i--) {
			char c = str.charAt(i);
			if(c >= '0' && c <= '9') {
				t = c - '0';
			} else {
				t = c - 'A' + 10;
			}
			
			res += t * pow;
			pow *= 16;
		}
		
		return res;
	}
	
}

package acmicpc;

public class BOJ_4673 {
	
	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/4673
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static int[] res = new int[10001];
	
	public static void main(String[] args) {
		for(int i = 1; i < res.length; i++) {
			if(res[i] == 0) mark(next(i));
		}
		
		for(int i = 1; i < res.length; i++) {
			if(res[i] == 0) System.out.println(i);
		}
		
	}
	
	public static int next(int n) {
		int res = n;
		while(n >= 1) {
			res += n%10;
			n /= 10;
		}
		return res;
	}
	
	public static void mark(int n) {
		if(n > 10000) return;
		res[n] = 1;
		mark(next(n));
	}
}

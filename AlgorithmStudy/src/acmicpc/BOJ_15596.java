package acmicpc;

public class BOJ_15596 {

	/**
	 * <pre>
	 * My solution for https://www.acmicpc.net/problem/15596
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static long sum(int[] a) {
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) sum += a[i];
		
		return sum;
	}

}

package programmers;

public class PG_17681 {
	
	/**
	 * <pre>
	 * My solution for https://programmers.co.kr/learn/courses/30/lessons/17681
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] answer = solution(n, arr1, arr2);
		
		System.out.println("22 | 14 = " + (22|14));
		System.out.println("31 | 14 = " + (31|14));
		
		for(int i = 0; i < n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) { 
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
        	int[] tmp = decToBin(arr1[i], arr2[i], n);
        	StringBuilder str = new StringBuilder();
        	for(int j = 0; j < n; j++) {
        		if(tmp[j] == 1) str.append("#");
        		else str.append(" ");
        	}
        	answer[i] = str.toString();
        }
        return answer;
    }
	
	public static int[] decToBin(int a, int b, int size) {
		int[] res = new int[size];
		int num = a | b;
		
		int idx = size -1;
		for(int i = size - 1; i >= 0; i--) {
			res[idx--] = num % 2;
			num /= 2;
		}
		return res;
	}
}

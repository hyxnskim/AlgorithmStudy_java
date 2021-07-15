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
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] answer = solution(n, arr1, arr2);
		
		for(int i = 0; i < n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) { 
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
        	int[] tmp = decToBin(arr1[i], arr2[i], n);
        	String str = " ";
        	for(int j = 0; j < n; j++) {
        		if(tmp[j] == 1) str.concat("#");
        		else str.concat(" ");
        	}
        	answer[i] = str;
        	System.out.println(str);
        }
        
        return answer;
    }
	
	public static int[] decToBin(int a, int b, int size) {
		int[] res = new int[size];
		int num = a | b;
		
		int idx = size -1;
		while(num > 1) {
			res[idx--] = num % 2;
			num /= 2;
		}
		res[0] = num;
		
		return res;
	}

}

package week1.queue_stack;

import java.util.Stack;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42584
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class Stock {

	public static void main1(String[] args) {
		int[] sol = {1, 2, 3, 2, 3};
		int[] temp = Solution(sol);
		for(int i = 0; i < temp.length; i++) System.out.println(temp[i]);

	}

	public static int[] Solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		Stack<Integer> st = null;  
		
		for(int i = 0; i < len; i++) {
			st = new Stack<Integer>();
			st.add(prices[i]);
			int j = i + 1;
			for(; j < len; j++) {
				if(prices[j] >= prices[i]) st.add(prices[j]);
				else {
					answer[i] = st.size();
					break;
				}
			}
			if(j == len) answer[i] = st.size() - 1;
		}
		return answer;
	}
}

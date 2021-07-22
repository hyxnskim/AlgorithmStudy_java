package programmers;

import java.util.Arrays;

public class PG_42577 {
	
	/**
	 * <pre>
	 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42577
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book));
	}
	
	 public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        loop:
        for(int i = 0; i < phone_book.length && answer; i++) {
        	for(int j = i+1 ; j < phone_book.length; j++) {
        		if(phone_book[j].startsWith(phone_book[i])) {
        			answer = false;
        			break loop;
        		}
        	}
        }
        return answer;
	 }
}

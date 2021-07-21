package programmers;

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
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	
	 public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++) {
        	for(int j = 0; j < phone_book.length; j++) {
        		if(i == j) continue;
        		if(phone_book[i].startsWith(phone_book[j])) {
        			answer = false;
        			break;
        		}
        	}
        }
        return answer;
	 }
}

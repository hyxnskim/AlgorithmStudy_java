package programmers;

import java.util.HashSet;

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

        HashSet<String> set = new HashSet<>();
        for(String p : phone_book) set.add(p);
        
        Loop :
        for(String p : phone_book){
            for(int i = 0; i < p.length(); i++) {             
                if(set.contains(p.substring(0,i))) {
                	answer = false; 
                	break Loop;
                }
            }
        }
        return answer;
	 }
}

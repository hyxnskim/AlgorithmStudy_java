package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		String[] phone_book = {"97674223", "119","1195524421"};
		System.out.println(solution(phone_book));
	}
	
	 public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < phone_book.length; i++)
        	list.add(phone_book[i]);
        
        Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() > s2.length()) return 1;
				else return -1;
			}
		});
        
        Loop:
        for(int i = 0; i < list.size(); i++) {
        	String str = list.get(i);
        	for(int j = 0; j < i; j++) {
        		if(str.startsWith(list.get(j))) {
        			answer = false;
        			break Loop;
        		}
        	}
        }
        return answer;
	 }
}

package programmers;

import java.util.ArrayList;

public class PG_42576 {
	
	/**
	 * <pre>
	 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42576
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));

	}
	
	public static String solution(String[] participant, String[] completion) {
        ArrayList<String> par = new ArrayList<String>();
        
        for(int i = 0; i < participant.length; i++) {
        	par.add(participant[i]);
        }
        
        for(int i = 0; i < completion.length; i++) {
        	String tmp = completion[i];
        	if(par.contains(tmp)) {
        		par.remove(tmp);
        	} else {
        		return tmp;
        	}
        }
        
        return par.get(0);
    }
}

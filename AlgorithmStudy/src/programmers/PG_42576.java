package programmers;

import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<String> com = new ArrayList<String>();
        
        int i = 0;
        for( ; i < completion.length; i++) {
        	par.add(participant[i]);
        	com.add(completion[i]);
        }
        par.add(participant[i]);
        
        par.sort(null);
        Collections.sort(par);
        Collections.sort(com);
        
        
        for(i = 0; i < completion.length; i++) {
        	String tmp = par.get(i);
        	if(!tmp.equals(com.get(i))) return tmp;
        }
        
        return par.get(par.size()-1);
    }
}

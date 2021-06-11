package week1.queue_stack;

import java.util.ArrayList;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42586
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class Dev {
	public static void main2(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] temp = solution(progresses, speeds);
		for(int tmp : temp) {
			System.out.println(tmp);
		}
		
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> plist = new ArrayList<Integer>(); 
        ArrayList<Integer> slist = new ArrayList<Integer>(); 
        ArrayList<Integer> res = new ArrayList<Integer>(); 
        
        for(int i = 0; i < progresses.length; i++) {
    		plist.add(progresses[i]);
    		slist.add(speeds[i]);
    	}
        
        int prog;
        while(true) {
        	for(int i = 0; i < plist.size(); i++) {
        		prog = plist.get(i);
        		plist.set(i, prog + slist.get(i));
        	}
        	
        	if(plist.get(0) >= 100) {
        		int cnt = 0;
        		for(int i = 0; i < plist.size(); i++) {
        			if(plist.get(i) >= 100) cnt++;
        			else break;
        		}
        		res.add(cnt);
        		
        		for(int i = 0; i < cnt; i++) {
        			plist.remove(0);
        			slist.remove(0);
        		}
        	}
        	if(plist.isEmpty()) break;
        }
        
        answer = new int[res.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = res.get(i);
        }
        return answer;
    }
}

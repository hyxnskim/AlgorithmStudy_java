package week1.queue_stack;

import java.util.ArrayList;

	/**
	 * <pre>
	 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42583
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
public class Truck {

	public static void main(String[] args) {
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(solution(100, 100, truck_weights));
	}

	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int cnt = 1;
        int finished = 0;	// 이동 완료한 트럭 수
        int started = 0;	// 출발한 트럭 수
        int on = 0;	// 현재 다리 위에 있는 트럭 수
        
        ArrayList<Integer> truck = new ArrayList<Integer>();
        for(int i = 0; i < truck_weights.length; i++) {
        	truck.add(truck_weights[i]);
        }
        
        int[] move = new int[truck_weights.length];
        for(int i = 0; i < move.length ; i++) {
        	move[i] = 0;
        }

        int newTruck = 0;
        int sum = 0;
        while(true) {
	    	if(!truck.isEmpty()) { 
	    		newTruck = truck.get(0);
	        	if(sum + newTruck <= weight && on < bridge_length) {
	        		sum += newTruck;
	        		truck.remove(0);
	        		started++;
	        		on++;
	        	}
	    	}
	        	
	    	for(int i = finished ; i < started ; i++) {
	    		move[i]++;
	    		if(move[i] == bridge_length) {
	    			finished++;
	    			on--;
	    			sum -= truck_weights[i];
	    		}
	    	}
	    		        	
	    	cnt++;
	    	if(finished == truck_weights.length) break;
        }
        return cnt;
    }
}

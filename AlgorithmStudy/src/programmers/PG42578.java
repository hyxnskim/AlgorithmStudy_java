package programmers;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42578
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;

public class PG_42578 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    
    static ArrayList<Category> list;
	static int answer = 0;
    
    public int solution(String[][] clothes) {
      answer = 0;
        
        list = new ArrayList<>();
        
        for(int i = 0; i < clothes.length; i++) {
        	
        	if(list.size() == 0) {
        		list.add(new Category(clothes[i][1]));
        	} else {
        		boolean flag = false;
        		for(int j = 0; j < list.size(); j++) {
        			if(list.get(j).ct.equals(clothes[i][1])) {
        				list.get(j).cnt++;
        				flag = true;
        				break;
        			}
        		}
        		if(!flag) {
        			list.add(new Category(clothes[i][1]));
        		}
        	}
        }
        
//	        for(int i = 0; i < list.size(); i++) {
//	        	System.out.println("[" + list.get(i).ct + "] " + list.get(i).cnt);
//	        }
        
        // 1가지
        for(int i = 0; i < list.size(); i++) {
        	answer += list.get(i).cnt;
        }
        
        // 2가지 이상
        for(int i = 2; i <= list.size(); i++) {
        	boolean[] isVisited = new boolean[list.size()];
        	comb(isVisited, 0, list.size(), i);
        }
        
        return answer;
    }
	
	public static void comb(boolean[] isVisited, int start, int n, int r) {
		if(r == 0) {
			int res = 1;
			for(int i = 0; i < n; i++) {
				if(isVisited[i]) res *= list.get(i).cnt;
			}
			answer += res;
		}
		
		for(int i = start; i < n; i++) {
			isVisited[i] = true;
			comb(isVisited, i+1, n, r-1);
			isVisited[i] = false;
		}
	}
	
}


class Category{
	String ct;
	int cnt;
	
	Category(String ct){
		this.ct = ct;
		this.cnt = 1;
	}
}

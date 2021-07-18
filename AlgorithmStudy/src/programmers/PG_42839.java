package programmers;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42839
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class PG_42839 {

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
	
	/*
	 * << 방법1 - 사용 >>
	 * 1. 문자열을 각각의 숫자로 분리한다.
	 * 2. 숫자의 조합으로 만들 수 있는 가장 큰 수보다 작은 가장 큰 소수 maxPrime을 찾는다.
	 * 3. 2 ~ maxPrime 사이의 소수들 추출
	 * 4. 숫자의 조합으로 해당 소수들을 만들 수 있는지 검사
	 * 
	 * << 방법2 >>
	 * 1. 문자열을 각각의 숫자로 분리한다.
	 * 2. 숫자의 조합으로 만들 수 있는 모든 수를 만든다
	 * 3. 만들어진 수가 소수인지 검사한다.
	 * 	>> 소수 검사용 함수 따로 만들기
	 * * 만들어진 수를 저장하진 않고 만든 즉시 소수인지 확인 후 count값만 갱신
	 */
	
	public static int solution(String numbers) {
        int answer = 0;
        
        // 1. 문자열을 각각의 숫자로 분리
        ArrayList<Integer> nums = stringToInt(numbers);
        
        // 2. 숫자의 조합으로 만들 수 있는 가장 큰 수보다 작은 가장 큰 소수 maxPrime을 찾는다.
        // 2-1. nums 내림차순 정렬
        nums.sort(Comparator.reverseOrder());

        // 2-2. 내림차순 정렬된 nums배열 하나의 정수로 만들기
        int max = 0;
        for(int i = 0; i < nums.size() ; i++) {
        	max = max * 10 + nums.get(i);
        }
        System.out.println("max = " + max);
        
        // 2-3. 해당 정수보다 작은 가장 큰 소수 찾기
        int maxPrime = 0;
        while(max > 1) {
        	if(isPrime(max)) {
        		maxPrime = max;
        		break;
        	}
        	max--;
        }

        System.out.println("maxPrime = " + maxPrime);
        
        System.out.println("-------------------");
        // 3. 2 ~ maxPrime 사이의 소수들 추출
        for(int i = 2; i <= maxPrime; i++) {
        	if(isPrime(i)) {
        		if(isAble(i, nums)) {
        			System.out.println(i);
        			answer++;
        		}
        	}
        }
        System.out.println("-------------------");
        return answer;
    }
	
	/**
	 * 문자열을 숫자 배열로 변롼
	 * @param num 변환할 문자열
	 * @return 변롼된 숫자 배열
	 */
	public static ArrayList<Integer> stringToInt(String num) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < num.length(); i++) {
        	arr.add((Integer)(num.charAt(i) - '0'));
        }
		return arr;
	}
	
	/**
	 * 소수 검사 메서드
	 * @param num 검사 대상 수
	 * @return 소수이면 true, 소수가 아니면 false 반환
	 */
	public static boolean isPrime(int num) {
		if(num < 2) return false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	/**
	 * 숫자 배열의 조합으로 소수를 만들 수 있는지 검사
	 * @param prime 만들어질 소수
	 * @param numArr 조합할 숫자 배열
	 * @return 조합 가능하면 true, 불가능하면 false
	 */
	public static boolean isAble(int prime, ArrayList<Integer> numArr) {
		ArrayList<Integer> primeArr = stringToInt(Integer.toString(prime));
		ArrayList<Integer> tmpArr = (ArrayList<Integer>) numArr.clone();
		
		if(!numArr.containsAll(primeArr)) return false;
		
		int tmp;
		for(int i = 0; i < primeArr.size(); i++) {
			tmp = primeArr.get(i);
			if(tmpArr.contains(tmp)) {
				tmpArr.remove((Object)tmp);
			} else {
				return false;
			}
		}
		return true;
	}
}

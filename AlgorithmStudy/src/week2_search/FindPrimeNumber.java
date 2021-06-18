package week2_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42839
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class FindPrimeNumber {

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
        Integer[] nums = stringToInt(numbers);
        
        // 2. 숫자의 조합으로 만들 수 있는 가장 큰 수보다 작은 가장 큰 소수 maxPrime을 찾는다.
        // 2-1. nums 내림차순 정렬
        Arrays.sort(nums, Collections.reverseOrder());

        // 2-2. 내림차순 정렬된 nums배열 하나의 정수로 만들기
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
        	max = max * 10 + nums[i];
        }
        System.out.println("max = " + max);
        
        // 2-3. 해당 정수보다 작은 가장 큰 소수 찾기
        int maxPrime = 0;
        while(max > 0) {
        	if(isPrime(max)) {
        		maxPrime = max;
        		break;
        	}
        	max--;
        }
        if(maxPrime < 2) {
        	answer = 0;
        	return answer;
        }
        System.out.println("maxPrime = " + maxPrime);
        
        // 3. 2 ~ maxPrime 사이의 소수들 추출
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i <= maxPrime; i++) {
        	if(isPrime(i)) primes.add(i);
        }
        
        System.out.println("--------------------------");
        // 4. 숫자의 조합으로 해당 소수들을 만들 수 있는지 검사
        for(int i = 0; i < primes.size(); i++) {
        	if(isAble(primes.get(i), nums)) answer++;
        }
        System.out.println("--------------------------");
        
        return answer;
    }
	
	/**
	 * 문자열을 숫자 배열로 변롼
	 * @param num 변환할 문자열
	 * @return 변롼된 숫자 배열
	 */
	public static Integer[] stringToInt(String num) {
		Integer[] arr = new Integer[num.length()];
		for(int i = 0; i < num.length(); i++) {
        	arr[i] = (int)(num.charAt(i) - '0');
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
		for(int i = 2; i < num; i++) {
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
	public static boolean isAble(int prime, Integer[] numArr) {
		Integer[] primeArr = stringToInt(Integer.toString(prime));
		Arrays.sort(primeArr, Collections.reverseOrder());
		
		int p = 0, n = 0;
		while(p < primeArr.length && n < numArr.length) {
			if(primeArr[p] > numArr[n]) {
				return false;
			}
			else if(primeArr[p] < numArr[n]) {
				n++;
			}
			else if(primeArr[p] == numArr[n]) {
				p++;
				n++;
			}
		}
		
		if(p == primeArr.length) {
			System.out.println(prime);
			return true;
		}
		return false;
	}
}

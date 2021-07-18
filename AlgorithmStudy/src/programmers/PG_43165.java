package programmers;

public class PG_43165 {

	/**
	 * <pre>
	 * My solution for https://programmers.co.kr/learn/courses/30/lessons/43165
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 5;
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		answer += findSum(numbers, target, numbers[0], 1);
		answer += findSum(numbers, target, -numbers[0], 1);
			
		return answer;
	}
	
	public static int findSum(int[] numbers, int target, int sum, int i) {
		
		if(i == numbers.length) {
			if(sum == target) return 1;
			else return 0;
		}
		
		int result = 0;
		result += findSum(numbers, target, sum + numbers[i], i + 1);
		result += findSum(numbers, target, sum - numbers[i], i + 1);
		return result;
	}
}

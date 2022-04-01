/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2480
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */
import java.util.Scanner;

public class BOJ_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[7];

		for(int i = 0; i < 3; i++){
			nums[sc.nextInt()]++;
		}

		int idx = 0, max = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] >= max){
				max = nums[i];
				idx = i;
			}
		}

		int answer = 0;
		if(max == 3){
			answer = 10_000 + 1_000 * idx;
		} else if (max == 2) {
			answer = 1_000 + 100 * idx;
		} else {
			answer = 100 * idx;
		}

		System.out.println(answer);
	}
}

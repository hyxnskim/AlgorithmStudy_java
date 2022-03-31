/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/2525
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */
import java.util.Scanner;

public class BOJ_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int hour = sc.nextInt();
		int min = sc.nextInt();
		int time = sc.nextInt();

		min += time;
		if(min >= 60){
			int t = min / 60;
			hour += t;
			min -= 60*t;
		}

		if(hour >= 24){
			hour -= 24;
		}

		System.out.printf("%d %d\n", hour, min);
	}
}

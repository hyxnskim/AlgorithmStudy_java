package swea.N1950_1959;

/**
 * <pre>
 * My solution for SWEA_1959
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1952_수영장 {
	
	static int[] fee;	// 1일, 1달, 3달, 1년 이용권 요금
	static int min;
	static int[] month = new int[13];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			fee = new int[4];
			
			for(int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}
	
			min = fee[3];
			for(int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
			}
			
			solution( 1, 0);
			
			System.out.printf("#%d %d\n", t+1, min);
		}
		
		sc.close();
	}
	
	public static void solution(int curMon, int ans) {
		
		if(curMon >= 13) {
			if(ans < min) min = ans;
			return;
		}
		
		if(month[curMon] == 0) {
			solution( curMon+1, ans);
		}
		else {
			
			for(int i = 0; i < 3; i++) {
				int newAns;
				
				if(i == 0) {
					newAns = ans + fee[0] * month[curMon];
					if(newAns > min) continue;
					solution(curMon+1, newAns);
					
				} else if(i == 1) {
					newAns = ans + fee[1];
					if(newAns > min) continue;
					solution(curMon+1, newAns);
					
				} else if(i == 2) {
					newAns = ans + fee[2];
					if(newAns > min) continue;
					solution(curMon+3, newAns);

				}
			}
			
		}
	}
}

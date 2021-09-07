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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			fee = new int[4];
			int[] month = new int[13];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}
	
			for(int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
			}
			
			solution(month, 1, 0);
			
			if(min > fee[3]) min = fee[3];
			System.out.printf("#%d %d\n", t+1, min);
		}
		
		sc.close();
	}
	
	public static void solution(int[] mon, int curMon, int ans) {
		
		if(curMon == 13) {
			if(ans < min) min = ans;
			return;
		}
		
		if(mon[curMon] == 0) {
			solution(mon, curMon+1, ans);
		}
		else {
			
			for(int i = 0; i < 3; i++) {
				int newAns;
				
				if(i == 0) {
					newAns = ans + fee[0] * mon[curMon];
					if(newAns > min) continue;
					solution(mon, curMon+1, newAns);
					
				} else if(i == 1) {
					newAns = ans + fee[1];
					if(newAns > min) continue;
					solution(mon, curMon+1, newAns);
					
				} else if(i == 2) {
					newAns = ans + fee[2];
					if(newAns > min) continue;
					
					int[] tmp = new int[3];
					int end = curMon <= 10 ? 3 : 13 - curMon;
					for(int j = 0; j < end; j++) {
						tmp[j] = mon[curMon + j];
						mon[curMon + j] = 0;
					}
					
					solution(mon, curMon+1, newAns);
					
					for(int j = 0; j < end; j++) {
						mon[curMon + j] = tmp[j];
					}
				}
			}
			
		}
	}
}

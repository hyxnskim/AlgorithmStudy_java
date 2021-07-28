package swea;

import java.util.Scanner;

public class SWEA_1210_Ladder {
	
	/**
	 * <pre>
	 * My solution for SWEA_1210
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=1210&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int[][] ladder;
	public static int S = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			ladder = new int[S][S];
			sc.nextInt();
			
			// 입력
			for(int i = 0; i < S; i++) {
				for(int j = 0; j < S; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			int i = 0;
			for(; i < S; i++) {
				int des = 0;
				if(ladder[0][i] == 1) {
					des = start(0, i);
				}
				if(des == 2) break;
			}
			res[t] = i;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		sc.close();
	}
	
	public static int start(int x, int y) {
		boolean sidedown = false;	// false면 좌우로 이동, true면 아래로 이동
		int leftright = 0; // 0이면 중립, 음수면 왼쪽으로, 양수면 오른쪽으로
		
		while(true) {
			if(leftright <= 0 && check(x, y-1) && ladder[x][y-1] == 1) {
				sidedown = false;
				leftright--;
			} else if(leftright >= 0 && check(x, y+1) && ladder[x][y+1] == 1) {
				sidedown = false;
				leftright++;
			} else {
				sidedown = true;
				leftright = 0;
			}
			
			if(sidedown) {
				x++;
			} else {
				if(leftright < 0) y--;
				else if(leftright > 0) y++;
			}
			
			if(x == S-1) break;
		}
		
		return ladder[x][y];
	}
	
	public static boolean check(int x, int y) {
		return (x >= 0 && x < S && y >= 0 && y < S);
	}
}

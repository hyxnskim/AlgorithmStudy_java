package swea.N1210_1219;

import java.util.Scanner;

public class SWEA_1215_Palindrome1 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1215
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14QpAaAAwCFAYi&categoryId=AV14QpAaAAwCFAYi&categoryType=CODE&problemTitle=1215&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static int S = 8;
	public static int len;
	public static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int t = 0; t < T; t++) {
			len = sc.nextInt();
			map = new char[S][S];
			int cnt = 0;
			
			for(int i = 0; i < S; i++) {
				String tmp = sc.next();
				for(int j = 0; j < S; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			
			for(int i = 0; i < S; i++) {
				for(int j = 0; j <= S - len; j++) {
					if(isPal_row(i, j)) cnt++;
					if(isPal_col(j, i)) cnt++;
				}
			}
			
			res[t] = cnt;
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, res[t]);
		}
		
		sc.close();
	}
	
	public static boolean isPal_row(int x, int y) {
		char[] str = new char[len];
		for(int i = 0; i < len; i++) {
			str[i] = map[x][y+i];
		}
		
		int s = 0, e = len -1;
		while(s <= e) {
			if(str[s] != str[e]) return false;
			s++; e--;
		}
		return true;
	}
	
	public static boolean isPal_col(int x, int y) {
		char[] str = new char[len];
		for(int i = 0; i < len; i++) {
			str[i] = map[x+i][y];
		}
		
		int s = 0, e = len -1;
		while(s <= e) {
			if(str[s] != str[e]) return false;
			s++; e--;
		}
		return true;
	}
}

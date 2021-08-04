package swea;

import java.util.Scanner;

public class SWEA_1233_사칙연산_유효성검사 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1233
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD&categoryId=AV141176AIwCFAYD&categoryType=CODE&problemTitle=1233&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	// 리프노드에 연산자가 있는지만 검사하면 될듯
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = 10;
			
			for(int t = 0; t < T; t++) {
				int N = Integer.parseInt(sc.nextLine());
				boolean check = false;
				
				for(int i = 1; i <= N; i++) {
					String str = sc.nextLine();
					
					if(!isValid(str.split(" "))) {
						check = true;
						//break;	// break해버리면 다음 테스트 케이스로 못 넘어가서 에러남
					}
				}
				System.out.printf("#%d %d\n", t+1, check ? 0 : 1);
			}
			sc.close();
		}
		
		public static boolean isValid(String[] arr) {
			if(arr[1].equals("-") || arr[1].equals("+") || arr[1].equals("*") || arr[1].equals("/")) {
				if(arr.length < 4) return false;
			}
			return true;
		}
}

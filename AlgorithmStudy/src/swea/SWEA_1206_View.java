package swea;

import java.util.Scanner;

public class SWEA_1206_View {
	
	/**
	 * <pre>
	 * My solution for SWEA_1206
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] res = new int[T];
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt = 0;
			
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			
			int[] height = new int[4];
			for(int j = 2; j < N-2; j++) {
				height[0] = arr[j-2];
				height[1] = arr[j-1];
				height[2] = arr[j+1];
				height[3] = arr[j+2];
				
				boolean check = false;
				int max = 0;
				for(int h : height) {
					if(h >= arr[j]) {
						check = true;
						break;
					}
					if(h > max) max = h;
				}
				
				if(check) continue;
				cnt += arr[j] - max;
			}
			res[i] = cnt;
		}
		
		for(int i = 0; i < T; i++) {
			System.out.printf("#%d %d\n", i+1, res[i]);
		}
		
		sc.close();
	}
}

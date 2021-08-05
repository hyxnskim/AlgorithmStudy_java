package swea.N1220_1229;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	
	/**
	 * <pre>
	 * My solution for SWEA_1225
	 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=1225&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
	 * </pre>
	 * @author Hyunsoo Kim
	 * @version ver.1.0
	 * @since jdk1.8
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] arr = {1, 2, 3, 4, 5};
		
		for(int t = 0; t < T; t++) {
			sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			int idx = 0;
			while(true) {
				int tmp = queue.poll() - (arr[idx++ % 5]);
				if(tmp <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(tmp);
			}
			
			System.out.printf("#%d", t+1);
			while(!queue.isEmpty()) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
		sc.close();
	}
}

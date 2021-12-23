/**
 * <pre>
 * My solution for https://www.acmicpc.net/problem/1002
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class BOJ_1002 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0; t < T; t++) {
			String str[] = sc.nextLine().split(" ");
			
			int[] arr = new int[str.length];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			int res;
			
			if(arr[0] == arr[3] && arr[1] == arr[4]) {
				if(arr[2] == arr[5]) res = -1;	// 동일한 원일때
				else res = 0;	// 두 원의 중심이 같지만 반지름이 다르면 교점이 없음
			} else {
				double dis = findDistance(arr[0], arr[1], arr[3], arr[4]);
				if(Math.pow(arr[2] - arr[5], 2) == dis) res = 1;	// 내접
				else if(Math.pow(arr[2] + arr[5], 2) == dis) res = 1;	// 외접
				else if(Math.pow(arr[2] + arr[5], 2) < dis) res = 0;	// 만나지 못하는 경우
				else if(Math.pow(arr[2] - arr[5], 2) > dis) res = 0;
				else res = 2;
			}
			
			System.out.println(res);
		}
		
		sc.close();
	}
	
	static int findDistance(int x1, int y1, int x2, int y2) {
		return (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}

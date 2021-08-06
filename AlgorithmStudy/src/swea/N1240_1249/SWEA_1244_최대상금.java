package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1244
 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=1244&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.Scanner;

public class SWEA_1244_최대상금 {
	
	public static int[] arr;
	public static int turn;
	public static int[][] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++){
			String str = sc.next();
			turn = sc.nextInt();
			list = new int[10][10];
			
			arr = new int[str.length()];
			for(int i = 0; i < str.length(); i++)
				arr[i] = Integer.parseInt(str.charAt(i) + "");
			
			int cnt = 0;
			while(turn > 0) {
				change(cnt++);
			}
			
			for(int i = 0; i < 10; i++) {
				if(list[i][0] <= 1) continue;
				sort(list[i]);
			}
			
			int res = 0;
			for(int i = 0; i < arr.length; i++)
				res = res * 10 + arr[i];
			
			System.out.printf("#%d %d\n", t+1, res);
		}
		sc.close();
	}
	
	public static void change(int start) {
		
		if(start >= arr.length) {
			turn--;
			swap(arr.length-1, arr.length-2);
			return;
		}
		
		// 뒤에서부터 가장 큰 값 찾기
		int max = arr.length - 1;
		for(int i = arr.length - 2; i >= start; i--) {
			if(arr[i] > arr[max]) max = i;
		}
		
		// 가장 큰 값의 인덱스가 가장 앞의 인덱스가 아닐 경우 swap
		if(max != start) {
			turn--;
			list[arr[max]][++list[arr[max]][0]] = max;
			swap(max, start);
		} else if(max == start && max > 0 && arr[max] == arr[max-1]) {
			turn--;
		} 
	}

	public static void sort(int[] indexs) {
		
		for(int i = 1; i <= indexs[0] - 1; i++) {
			int ii = indexs[i];
			for(int j = i+1 ; j <= indexs[0]; j++) {
				int jj = indexs[j];
				if((ii < jj && arr[ii] < arr[jj]) || (ii > jj && arr[ii] > arr[jj]))
					swap(ii, jj);
			}
		}
	}
	
	public static void swap(int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}
}

package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Samsung_2017_sf_am_1 {
	
	static int n;
	static int[][] mat;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int[] work_arr;
	static boolean[] isVisited, isVisited_work;
	static int sum_morning, sum_night;
	static ArrayList<Integer> list_night;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		mat = new int[n][n];
		arr = new int[n/2];
		work_arr = new int[2];
		isVisited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(min);
	}
	
	public static void solution() {
		list_night = new ArrayList<>();
		for(int i = 0; i < n; i++) list_night.add(i);
		for(int i : arr) list_night.remove(list_night.indexOf(i));
		
		sum_morning = 0;
		sum_night = 0;
		
		isVisited_work = new boolean[n/2];
		work_dfs(0, true);
		
		isVisited_work = new boolean[n/2];
		work_dfs(0, false);
		
		int tmp = Math.abs(sum_morning - sum_night);
		if(tmp < min) min = tmp;
		
	}
	
	public static void work_dfs(int depth, boolean isNight) {
		if(depth >= 2) {
			int tmp = mat[work_arr[0]][work_arr[1]];
			if(isNight) sum_night += tmp;
			else sum_morning += tmp;
			return;
		}
		
		if(isNight) {
			
			for(int i = 0; i < list_night.size(); i++) {
				if(!isVisited_work[i]) {
					isVisited_work[i] = true;
					work_arr[depth] = list_night.get(i);
					work_dfs(depth+1, isNight);
					isVisited_work[i] = false;
				}
			}
		} else {
			for(int i = 0; i < arr.length; i++) {
				if(!isVisited_work[i]) {
					isVisited_work[i] = true;
					work_arr[depth] = arr[i];
					work_dfs(depth+1, isNight);
					isVisited_work[i] = false;
				}
			}
		}
		
	}
	
	public static void dfs(int depth) {
		
		if(depth >= n/2) {
			solution();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				isVisited[i] = false;			
			}
		}
		return;
	}

}

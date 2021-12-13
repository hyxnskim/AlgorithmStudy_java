import java.util.Scanner;

public class SWEA_1865_동철이의일분배 {
	
	static double ans = 0;
	static int N;
	static double[][] mat;
	static int[] perm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine().split(" ")[0]);
		
		for(int t = 0; t < T; t++) {
			ans = 0;
			N = Integer.parseInt(sc.nextLine().split(" ")[0]);
			mat = new double[N][N];
	        
			 for(int i = 0; i < N; i++){
	             String[] str = sc.nextLine().split(" ");
	             for(int j=0 ; j<str.length ; j++){
	                 mat[i][j] = (double)Integer.parseInt(str[j]) / 100;
	             }
	         }

			 perm = new int[N];
			 for(int i = 0; i < N; i++) perm[i] = i;
			 
			 solve(0, 1);
			 System.out.printf("#%d %f\n", t+1, ans * 100);
		}
		
		sc.close();
	}
	
	static void solve(int k, double val) {
		if(k == N) {
			if(val > ans) ans = val;
		} else {
			for(int i = k; i < N; i++) {
				swap_perm(k, i);
				
				if((val * mat[k][perm[k]]) > ans) 
					solve(k+1, (val * mat[k][perm[k]]));
				swap_perm(i, k);
			}
		}
	}
	
	static void swap_perm(int x, int y) {
		int tmp = perm[x];
		perm[x] = perm[y];
		perm[y] = tmp;
	}

}

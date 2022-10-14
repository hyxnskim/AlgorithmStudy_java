package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung_2022_ws_pm_2 {
	
	static int n, m, k, c;	// 격자의 크기, 박멸 진행 년 수, 제초제 확산 범위, 제초제 남아있는 년 수
	static int[][] mat, cntBlank;
	static int cnt = 0;
	static int[] killPos = {0, 0};
	
	static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼, 오
	static int[] dy = {0, 0, -1, 1};
	
	static int[] dxc = {-1, -1, 1, 1}; // 좌상, 우상, 좌하, 우하
	static int[] dyc = {-1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		mat = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(m-- > 0) {
			solution();
		}
		
		System.out.println(cnt);
		
	}
	
	public static void solution() {
		
		// 제초제 지속년수 감소
		init();
		
		// 나무 성장
		grow();
//		System.out.println("==========GROW==========");
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 나무 번식
		reproduce();
//		System.out.println("========REPRODUCE========");
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 제초제 뿌릴 위치 찾기
		findPos();
//		System.out.println("========FINDPOS========");
//		System.out.printf("KILLPOS = (%d, %d)\n", killPos[0], killPos[1]);
		
		// 제초제 뿌리기
		kill();
//		System.out.println("==========KILL==========");
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void kill() {
		if(killPos[0] == -1 && killPos[1] == -1) return;
		
		cnt += mat[killPos[0]][killPos[1]];
		mat[killPos[0]][killPos[1]] = -2 * (c+1);
		
		for(int i = 0; i < 4; i++) {
			Loop:
			for(int j = 1; j <= k; j++) {
				int x = killPos[0] + dxc[i]*j;
				int y = killPos[1] + dyc[i]*j;
				
				if(!isWall(x, y)) {
					if(mat[x][y] == -1) break Loop;
					else if(mat[x][y] == 0) {
						mat[x][y] = -2 * (c+1);
						break Loop;
					} else if(mat[x][y] < -1) {
						mat[x][y] = -2 * (c+1);
					} else {
						cnt += mat[x][y];
						mat[x][y] = -2 * (c+1);
					}
					
				}
			}
		}
		
	}
	
	public static void findPos() {
		killPos[0] = -1; killPos[1] = -1;
		int max = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				int _cnt = 0;
				if(mat[i][j] > 0) {
					_cnt += mat[i][j];
					
					for(int t1 = 0; t1 < 4; t1++) {
						Loop:
						for(int t2 = 1; t2 <= k; t2++) {
							int x = i + dxc[t1]*t2;
							int y = j + dyc[t1]*t2;
							
							if(!isWall(x, y)) {
								if(mat[x][y] <= 0) break Loop;
								_cnt += mat[x][y];
							}
						}
					}
				}
				
				if(_cnt > max) {
					max = _cnt;
					killPos[0] = i; killPos[1] = j;
				}
			}
		}
	}
	
	public static void reproduce() {
		int[][] _mat = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(mat[i][j] > 0) {
					if(cntBlank[i][j] == 0) continue;
					int newTrees = mat[i][j] / cntBlank[i][j];
					
					for(int l = 0; l < 4; l++) {
						int x = i + dx[l];
						int y = j + dy[l];
						
						if(!isWall(x, y) && mat[x][y] == 0) _mat[x][y] += newTrees;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(_mat[i][j] > 0) mat[i][j] = _mat[i][j];
			}
		}
	}
	
	public static void grow() {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(mat[i][j] > 0) {
					int _cnt = 0;
					int _cntBlank = 0;
					
					for(int l = 0; l < 4; l++) {
						int x = i + dx[l];
						int y = j + dy[l];
						
						if(!isWall(x, y)) {
							if(mat[x][y] > 0) _cnt++;
							else if(mat[x][y] == 0) _cntBlank++;
						}
					}
					
					mat[i][j] += _cnt;
					cntBlank[i][j] = _cntBlank;
				}
			}
		}
		
	}
	
	
	public static void init() {
		cntBlank = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] < -1) mat[i][j] += 2;
			}
		}
	}
	
	public static boolean isWall(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}

}

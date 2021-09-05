package swea.N1250_1259;

/**
 * <pre>
 * My solution for SWEA_1259
 * Source of the problem: https://swexpertacademy.com/
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1259_금속막대 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			// 입력
			int N = sc.nextInt();
			ArrayList<Stick> sticks = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				sticks.add(new Stick(sc.nextInt(), sc.nextInt()));
			}
			
			// 맨 앞 막대 찾기
			Stick start = null;
			for(int i = 0; i < N; i++) {
				boolean flag = false;;
				int out = sticks.get(i).out;
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					if(sticks.get(j).in == out) flag = true;
				}
				if(!flag) {
					start = sticks.get(i);
					sticks.remove(i);
					break;
				}
			}
			
			// 막대 연결 및 출력
			System.out.printf("#%d %d %d ", t+1, start.out, start.in);
			while(!sticks.isEmpty()) {
				for(int i = 0; i < sticks.size(); i++) {
					Stick now = sticks.get(i);
					if(now.out == start.in) {
						System.out.print(now.out + " " + now.in + " ");
						start = now;
						sticks.remove(i);
					}
				}
			}
			System.out.println();
		}
		
		sc.close();
	}

}

class Stick{
	int out, in;
	Stick(int out, int in){
		this.out = out;
		this.in = in;
	}
}
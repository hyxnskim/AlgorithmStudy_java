package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1931 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Conf> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Conf(st.nextToken(), st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Conf>() {
			@Override
			public int compare(Conf c1, Conf c2) {
        /* 종료시간이 동일할 경우 시작시간 기준 오름차순으로 정렬해야함 */
				if(c1.end == c2.end) return Long.compare(c1.start, c2.start);
				return Long.compare(c1.end, c2.end);
			}
		});

		
		int cnt = 0;
		long start = (long) 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).start >= start) {
				start = list.get(i).end;
				cnt++;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

}

class Conf{
	long start, end;
	
	Conf(String start, String end){
		this.start = Long.parseLong(start);
		this.end = Long.parseLong(end);
	}
}

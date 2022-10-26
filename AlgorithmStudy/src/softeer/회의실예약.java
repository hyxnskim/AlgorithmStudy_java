// https://softeer.ai/practice/info.do?idx=1&eid=626

import java.util.*;
import java.io.*;


public class Main {

    static int N, M;
    static ArrayList<String> rooms;
    static ArrayList<Time>[] reservations;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        rooms = new ArrayList<>();
        for(int i = 0; i < N; i++) rooms.add(br.readLine());
        Collections.sort(rooms);

        reservations = new ArrayList[N];
        for(int i = 0; i < N; i++){
            reservations[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int idx = rooms.indexOf(st.nextToken());
            reservations[idx].add(new Time(st.nextToken(), st.nextToken()));
        }

        for(int i = 0; i < N; i++){
            solution(i);
        }

    }

    public static void solution(int idx) {

        int[] available = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        char[] occupied = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
        String room = rooms.get(idx);
        ArrayList<Time> times = reservations[idx];

        for(int i = 0; i < times.size(); i++){
            Time time = times.get(i);
            occupied[time.start-9] = 's';
            if(occupied[time.end-9] != 's') occupied[time.end-9] = 'e';

            for(int j = time.start+1; j < time.end; j++) occupied[j-9] = 'x';
        }

        times = new ArrayList<Time>();
        int s = -1, e = -1;
        for(int i = 0; i < occupied.length; i++){
            if(occupied[i] == '-' && s == -1) s = i;
            else if(occupied[i] == 's' || i == occupied.length - 1){
                if(s != -1) times.add(new Time(available[s], i+9));
                s = -1;
            } else if(occupied[i] == 'e'){
                s = i;
            }
        }

        System.out.println("Room " + room + ":");
        if(times.size() == 0) System.out.println("Not available");
        else{
            System.out.println(times.size() + " available:");
            for(int i = 0; i < times.size(); i++){
                System.out.printf("%02d-%02d\n", times.get(i).start, times.get(i).end);
            }
        }
        if(idx < N-1) System.out.println("-----");
    }
}

class Time{
    int start, end;

    Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    Time(String start, String end){
        this.start = Integer.parseInt(start);
        this.end = Integer.parseInt(end);
    }
}

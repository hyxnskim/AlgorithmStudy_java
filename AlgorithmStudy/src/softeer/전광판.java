// https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_93933&psProblemId=624#hold

mport java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] bulbs = {{0, 4, 3, 3, 4, 3, 2, 2, 1, 2},
                        {4, 0, 5, 3, 2, 5, 6, 2, 5, 4},
                        {3, 5, 0, 2, 5, 4, 3, 5, 2, 3},
                        {3, 3, 2, 0, 3, 2, 3, 3, 2, 1},
                        {4, 2, 5, 3, 0, 3, 4, 2, 3, 2},
                        {3, 5, 4, 2, 3, 0, 1, 3, 2, 1},
                        {2, 6, 3, 3, 4, 1, 0, 4, 1, 2},
                        {2, 2, 5, 3, 2, 3, 4, 0, 3, 2},
                        {1, 5, 2, 2, 3, 2, 1, 3, 0, 1},
                        {2, 4, 3, 1, 2, 1, 2, 2, 1, 0}};
        int[] toNone = {6, 2, 5, 5, 4, 5, 6, 4, 7, 6};


        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = toArray(A);
            int[] arrB = toArray(B);

            int cnt = 0;
            for(int i = 0; i < 5; i++){
                if(arrA[i] == -1 && arrB[i] == -1) continue;
                else if(arrA[i] == -1) {
                    cnt += toNone[arrB[i]];
                    continue;
                } else if(arrB[i] == -1) {
                    cnt += toNone[arrA[i]];
                    continue;
                }

                cnt += bulbs[arrA[i]][arrB[i]];
            }

            System.out.println(cnt);

        }
    }

    public static int[] toArray(int n){
        int[] res = new int[5];
        int cnt = 0;

        int idx = 4;
        while(n >= 1){
            res[idx--] = n % 10;
            n /= 10;
            cnt++;
        }

        for(int i = 0; i < 5 - cnt; i++) res[i] = -1;
        return res;
    }
}

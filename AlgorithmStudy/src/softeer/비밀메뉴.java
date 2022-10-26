import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] secret = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) secret[i] = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());

        if(N < M){
            System.out.println("normal");
            return;
        }

        for(int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());

        //// 입력 및 전처리 끝
        
        
        for(int i = 0; i <= N-M; i++){
            int idx = 0;
            boolean isSecret = true;
            for(int j = i; j < i+M; j++){
                if(secret[idx++] != input[j]){
                    isSecret = false;
                    break;
                }
            }
            if(isSecret){
                System.out.println("secret");
                return;
            }
        }
        
        System.out.println("normal");

    }
}

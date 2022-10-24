// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int[] dx = {-1, 1 , 0, 0};  // 상하좌우
        int[] dy = {0, 0, -1, 1};
        int size = garden.length;
        
        while(!isFull(garden)){
            answer++;
            int[][] tmp = new int[size][size];
            
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    
                    if(garden[i][j] == 1){
                        for(int d = 0; d < 4; d++){
                            int x = i + dx[d];
                            int y = j + dy[d];
                            
                            if(!isWall(x, y, size) && garden[x][y] == 0) tmp[x][y] = 1;
                        }
                    }
                }
            }
            
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(tmp[i][j] == 1) garden[i][j] = 1;
                }
            }
            
        }
        
        return answer;
    }
    
    public boolean isWall(int x, int y, int n){
        return x < 0 || x >= n || y < 0 || y >= n;
    }
    
    public boolean isFull(int[][] garden){
        for(int i = 0; i < garden.length; i++){
            for(int j = 0; j < garden[i].length; j++){
                if(garden[i][j] == 0) return false;
            }
        }
        return true;
    }
    
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }    
}

/**
 * 
 */
package programmers;

/**
 * <pre>
 * My solution for https://programmers.co.kr/learn/courses/30/lessons/42840
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */
public class PG_42840 {

	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		int[] res = solution(answers);
		for(int i = 0; i< res.length; i++) {
			if(res[i] != 0) System.out.println(i+1);
		}
	}
	
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] cnt = {0, 0, 0};
        int count=0;
        
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int c1 = 0, c2 = 0, c3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
        	if(s1[i % s1.length] == answers[i]) c1++;
        	if(s2[i % s2.length] == answers[i]) c2++;
        	if(s3[i % s3.length] == answers[i]) c3++;
        }
        
        int max = Math.max(Math.max(c1, c2),  c3);
        if(c1 == max) {
        	cnt[0] = 1; count++;
        }
        if(c2 == max) {
        	cnt[1] = 1; count++;
        }
        if(c3 == max) {
        	cnt[2] = 1; count++;
        }
        
        answer = new int[count];
        count = 0;
        for(int i = 0; i < cnt.length; i++) {
        	if(cnt[i] == 1) answer[count++] = i+1;
        }
        return answer;
    }

}

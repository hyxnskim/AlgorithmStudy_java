package swea.N1240_1249;

/**
 * <pre>
 * My solution for SWEA_1242
 * Source of the problem: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15JEKKAM8CFAYD&categoryId=AV15JEKKAM8CFAYD&categoryType=CODE&problemTitle=1242&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1242_암호코드스캔 {
	
	public static int N, M;
	public static ArrayList<String> input;
	public static int[] digit;
	public static String[] code = {"0001101", "0011001", "0010011", "0111101", "0100011", 
									"0110001", "0101111", "0111011", "0110111", "0001011"};
	public static String[] decToBin = {"0000", "0001", "0010", "0011", "0100", "0101",
										"0110", "0111", "1000", "1001"};
	public static String[] hexToBin = {"1010", "1011", "1100", "1101", "1110", "1111"};
	public static int sum = 0;
	public static ArrayList<String> validCodes;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 전체 테스트 케이스의 수
		
		for(int t = 0; t < T; t++) {			
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine();
			
			input = new ArrayList<>();
			digit = new int[8];
			sum = 0;
			validCodes = new ArrayList<>();
			
			// 1. 배열 입력받기
			// 2. 각 라인을 16진수 -> 2진수로 변환하기
			// 3. 이전 문제와 동일한 방법으로 유효한 암호코드 찾기
			String str;
			for(int i = 0; i < N; i++) {
				str = sc.nextLine();
				if(!input.contains(str)) {
					process(newString(str));
					input.add(str);
				}
			}
			
			System.out.printf("#%d %d\n", t+1, sum);
		}
		sc.close();
	}
	
	public static String newString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= '0' && c <= '9') sb.append(decToBin[Integer.parseInt(c + "")]);
			else sb.append(hexToBin[c-'A']);
		}
		return sb.toString();
	}
	
	public static void process(String str) {
		int maxLen = str.length() / 56;
		
		for(int t = 1; t <= maxLen; t++) {
			String[] tcode = new String[10];
			for(int i = 0; i < 10; i++) {
				tcode[i] = longString(code[i], t);
			}
			int end = str.length() - 56 * t;
			
			for(int i = 0; i <= end; i++) {
				int idx = 0;
				for(int j = 0; j < 8; j++) {
					String tmp = str.substring(j * 7 * t + i, (j * 7 + 7) * t + i);
					
					int k = 0;
					for(; k < code.length; k++) {
						if(tmp.equals(tcode[k])) {
							digit[idx++] = k;
							break;
						}
					}
					if(k == code.length) break;
				}
				if(idx == 8 && isValid()) {
					i++;
					String tmp = arrToString(digit);
					if(!validCodes.contains(tmp)) {
						addSum();
						validCodes.add(tmp);
					}
				}
			}
		}
	}
	
	public static String longString(String original, int len) {
		if(len == 1) return original;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < original.length(); i++) {
			for(int j = 0; j < len; j++) sb.append(original.charAt(i));
		}
		return sb.toString();
	}
	
	public static boolean isValid() {
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) sum += digit[i] * 3;
			else sum += digit[i];
		}
		
		if(sum % 10 == 0) return true;
		return false;
	}
	
	public static String arrToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i : arr) sb.append(i);
		
		return sb.toString();
	}
	
	public static void addSum() {
		for(int i : digit) sum += i;
	}
}

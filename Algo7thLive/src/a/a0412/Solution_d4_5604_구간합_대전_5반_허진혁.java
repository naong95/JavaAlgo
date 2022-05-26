package a.a0412;

import java.io.*;
import java.util.*;
import java.math.*;

/*

*/
public class Solution_d4_5604_구간합_대전_5반_허진혁 {
	
	static long number[], answer, A, B, pos;
	
	static void insert(long l) {
		for(long i = l; i > 0; i /= 10) {// 위쪽부터 거꾸로
			String str = Long.toString(i);
			int t = str.charAt(str.length() - 1) - '0';
			number[t] += pos;// 그 자리 만큼 더하기
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5604.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			number = new long[10];
			answer = 0;
			pos = 1;
			if(A == 0) A = 1;

			while(A <= B) {
				while(A % 10 != 0 && A <= B) {
					insert(A);
					A++;
				}
				if(A > B) break;
				while(B % 10 != 9 && A <= B) {
					insert(B);
					B--;
				}
				long diff = B / 10 - A / 10 + 1;
				for(int i = 0; i < 10; i++) number[i] += diff * pos;
				pos *= 10;// 자릿수 올리기
				A /= 10;
				B /= 10;
			}
			for(int i = 1; i < 10; i++) {
				answer += (i * number[i]);
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
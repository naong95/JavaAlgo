package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2675_문자열반복_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2675.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			sb = new StringBuilder("");
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < n; k++) {
					sb.append(str.charAt(j));
				}
			}
			System.out.println(sb.toString().trim());
		}

		br.close();
	}
}
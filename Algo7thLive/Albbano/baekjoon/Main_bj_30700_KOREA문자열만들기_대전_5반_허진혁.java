package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30700_KOREA문자열만들기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30700.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] KOREA = { 'K', 'O', 'R', 'E', 'A' };
		char[] arr = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder("");
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (idx > 4) {
				idx -= 5;
			}

			if (arr[i] == KOREA[idx]) {
				sb.append(arr[i]);
				idx++;
			}
		}
		System.out.println(sb.toString().length());

		br.close();
	}
}
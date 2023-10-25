package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_9086_문자열_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_9086.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			sb = new StringBuilder("");
			sb.append(str.charAt(0)).append(str.charAt(str.length() - 1));
			System.out.println(sb.toString());
		}

		br.close();
	}
}
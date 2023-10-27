package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2444_별찍기7_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2444.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++) {
				sb.append(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for (int i = N - 1; i >= 1; i--) {
			for (int j = N - i; j >= 1; j--) {
				sb.append(" ");
			}
			for (int j = 2 * i - 1; j >= 1; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30802_웰컴키트_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30802.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int tT = 0;

		for (int i : arr) {
			if (i % T == 0) {
				tT += i / T;
			} else {
				tT += i / T + 1;
			}
		}
		sb.append(tT).append("\n").append(n / P).append(" ").append(n % P);
		System.out.println(sb.toString().trim());

		br.close();
	}
}
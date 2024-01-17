package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11659_구간합구하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11659.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < n + 1; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken());

			sb.append(arr[end] - arr[start]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10816_숫자카드2_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10816.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[20000001];

		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < m; i++) {
			sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
		}
		System.out.println(sb.toString().trim());

		br.close();
	}
}
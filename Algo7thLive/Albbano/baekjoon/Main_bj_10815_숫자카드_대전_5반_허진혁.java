package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10815_숫자카드_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10815.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb.toString().trim());
		br.close();
	}
}
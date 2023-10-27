package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10811_바구니뒤집기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10811.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		ArrayList<Integer> list;

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();

			for (int j = start; j <= end; j++) {
				list.add(arr[j]);
			}
			Collections.reverse(list);
			for (int j = 0; j < list.size(); j++) {
				arr[start + j] = list.get(j);
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}
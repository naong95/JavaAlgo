package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10810_공넣기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10810.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for (int j = start - 1; j < end; j++) {
				basket[j] = num;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(basket[i] + " ");
		}

		br.close();
	}
}
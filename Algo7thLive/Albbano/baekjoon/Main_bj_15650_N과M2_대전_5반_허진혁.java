package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_15650_N과M2_대전_5반_허진혁 {

	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_15650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		combi(0, 0);

		br.close();
	}

	public static void combi(int start, int cnt) {
		if (cnt == M) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			arr[cnt] = i + 1;
			combi(start + 1, cnt + 1);
		}
	}
}
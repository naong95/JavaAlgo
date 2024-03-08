package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1010_다리놓기_대전_5반_허진혁 {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1010.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(combi(M, N)).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static int combi(int M, int N) {
		if (dp[M][N] > 0) {
			return dp[M][N];
		}

		if (M == N || N == 0) {
			return dp[M][N] = 1;
		}

		return dp[M][N] = combi(M - 1, N - 1) + combi(M - 1, N);
	}
}
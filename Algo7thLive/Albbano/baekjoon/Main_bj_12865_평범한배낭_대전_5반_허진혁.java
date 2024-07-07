package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_12865_평범한배낭_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] weights = new int[n];
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			int weight = weights[i - 1];
			int value = values[i - 1];

			for (int w = 0; w <= k; w++) {
				if (w >= weight) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + value);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}

		System.out.println(dp[n][k]);
		br.close();
	}
}
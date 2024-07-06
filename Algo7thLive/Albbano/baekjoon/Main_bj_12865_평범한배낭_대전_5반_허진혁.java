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

		int[] dp = new int[n + 1]; // dp[i] i개 넣었을때 가치 최댓값
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			goods[i][0] = Integer.parseInt(st.nextToken());
			goods[i][1] = Integer.parseInt(st.nextToken());
			if (goods[i][0] <= k) {
				dp[1] = Math.max(dp[1], goods[i][1]);
			}
		}

		for (int i = 2; i < n + 1; i++) {

		}

		br.close();
	}
}
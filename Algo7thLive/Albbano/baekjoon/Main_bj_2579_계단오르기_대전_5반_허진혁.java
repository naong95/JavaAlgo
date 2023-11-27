package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2579_계단오르기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] step = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n + 1][2];
		dp[1][0] = dp[1][1] = step[1];

		for (int i = 2; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][1] + step[i];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + step[i];
		}

		System.out.println(Math.max(dp[n][0], dp[n][1]));
		br.close();
	}
}
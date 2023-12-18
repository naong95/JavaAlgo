package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30979_유치원생파댕이돌보기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder("Padaeng_i ");
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int total = 0;
		for (int i = 0; i < N; i++) {
			total += Integer.parseInt(st.nextToken());
		}

		if (total >= T) {
			sb.append("Happy");
		} else {
			sb.append("Cry");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
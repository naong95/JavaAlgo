package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1920_수찾기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < M; i++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}
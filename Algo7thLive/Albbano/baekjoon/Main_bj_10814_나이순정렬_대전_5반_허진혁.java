package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10814_나이순정렬_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10814.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[][] map = new String[n][2];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				map[i][j] = st.nextToken();
			}
		}

		Arrays.sort(map, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			sb.append(map[i][0]).append(" ").append(map[i][1]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
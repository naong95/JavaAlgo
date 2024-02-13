package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30980_여중생파댕이와공부를_대전_5반_허진혁 {
	public static void study(int i, int j, char[][] map) {
		int a = map[i][j - 1] - '0';
		int b = map[i][j + 1] - '0';

		if (a + b >= 10) {
			int k = (a + b) / 10;
			int l = (a + b) % 10;

			if (k == map[i][j + 3] - '0' && l == map[i][j + 4] - '0') {
				map[i][j - 2] = '*';
				map[i][j + 5] = '*';

				for (int s = j - 1; s < j + 5; s++) {
					map[i - 1][s] = '*';
					map[i + 1][s] = '*';
				}
			} else {
				map[i][j] = '/';
				map[i - 1][j + 1] = '/';
				map[i + 1][j - 1] = '/';
			}
		} else {
			if (map[i][j + 3] - '0' == a + b) {
				map[i][j - 2] = '*';
				map[i][j + 4] = '*';

				for (int s = j - 1; s < j + 4; s++) {
					map[i - 1][s] = '*';
					map[i + 1][s] = '*';
				}
			} else {
				map[i][j] = '/';
				map[i - 1][j + 1] = '/';
				map[i + 1][j - 1] = '/';
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30980.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[3 * n][8 * m];

		for (int i = 0; i < 3 * n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < 3 * n; i++) {
			for (int j = 0; j < 8 * m; j++) {
				if (map[i][j] == '+') {
					study(i, j, map);
				}
			}
		}

		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < 3 * n; i++) {
			for (int j = 0; j < 8 * m; j++) {
				sb.append(map[i][j]);
			}
			if (i == 3 * n - 1) {
				continue;
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

}
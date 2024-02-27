package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1987_알파벳_대전_5반_허진혁 {

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // A == 65

	static char[][] map;
	static boolean[] alpa;

	static int R, C, max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		alpa = new boolean[26];
		move(0, 0, 1);
		System.out.println(max);
		br.close();
	}

	public static void move(int r, int c, int cnt) {

		max = Math.max(max, cnt);
		alpa[map[r][c] - 65] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nc < 0 || nr < 0 || nr >= R || nc >= C || alpa[map[nr][nc] - 65]) {
				continue;
			}

			move(nr, nc, cnt + 1);
			alpa[map[nr][nc] - 65] = false;
		}
	}
}
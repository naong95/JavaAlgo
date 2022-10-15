package baekjoon;

import java.util.*;
import java.io.*;

/*
격자크기 최소차이 최대차이
나라별 인구 수
*/
public class Main_bj_16234_인구이동_대전_5반_허진혁 {

	static int N, L, R, day;
	static int[][] map;
	static boolean[][] v;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_16234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		day = 0;
		while (check(map)) {
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {
						bfs(i, j);
					}
				}
			}
			day++;
		}
		System.out.println(day);
		br.close();
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> nations = new LinkedList<>();
		v[r][c] = true;
		q.offer(new int[] { r, c });
		nations.add(new int[] { r, c });

		int total = map[r][c]; // 총 인구 수
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni < 0 || nj < 0 || ni >= N || nj >= N || v[ni][nj])
					continue;
				int diff = Math.abs(map[i][j] - map[ni][nj]);
				if (diff < L || diff > R)
					continue;
				v[ni][nj] = true;
				int[] nation = new int[] { ni, nj };
				nations.add(nation);
				q.offer(nation);
				total += map[ni][nj];
			}
		}
		if (q.isEmpty()) {
			int popul = total / nations.size();
			for (int k = 0; k < nations.size(); k++) {
				int[] cur = nations.get(k);
				int i = cur[0];
				int j = cur[1];
				map[i][j] = popul;
			}
		}
	}

	public static boolean check(int[][] ia) {
		boolean move = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				int diff = Math.abs(ia[i][j] - ia[i][j + 1]);
				if (L <= diff && diff <= R)
					move = true;
			}
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				int diff = Math.abs(ia[i][j] - ia[i + 1][j]);
				if (L <= diff && diff <= R)
					move = true;
			}
		}
		return move;
	}
}
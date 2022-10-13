package baekjoon;

import java.util.*;
import java.io.*;

/*
테스트 케이스
가로 세로 배추
*/
public class Main_bj_1012_유기농배추_대전_5반_허진혁 {

	static int M, N, K, count;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] v;

	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			q = new ArrayDeque<int[]>();
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1 && !v[j][k]) {
						bfs(j, k);
						count++;
					}
				}
			}

			System.out.println(count);
		}
		br.close();
	}

	public static void bfs(int r, int c) {
		v[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];

				if (0 > ni || ni >= N || 0 > nj || nj >= M || map[ni][nj] == 0 || v[ni][nj])
					continue;

				v[ni][nj] = true;
				q.offer(new int[] { ni, nj });
			}
		}
	}
}
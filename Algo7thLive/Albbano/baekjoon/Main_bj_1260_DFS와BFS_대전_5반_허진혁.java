package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1260_DFS와BFS_대전_5반_허진혁 {
	static int N, M, V, next;
	static int[][] map;
	static boolean[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		sb = new StringBuilder("");
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 1;
			map[c][r] = 1;
		}

		dfs(V);
		sb.append("\n");
		v = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
		br.close();
	}

	public static void dfs(int start) {
		v[start] = true;
		sb.append(start + " ");

		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && !v[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		v[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");

			for (int i = 1; i <= N; i++) {
				if (map[start][i] == 1 && !v[i]) {
					v[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
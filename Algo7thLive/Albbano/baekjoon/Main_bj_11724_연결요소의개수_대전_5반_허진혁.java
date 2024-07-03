package baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_11724_연결요소의개수_대전_5반_허진혁 {
	static int[][] graph;
	static boolean[] v;
	static int n, m;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11724.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		v = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[r][c] = 1;
			graph[c][r] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (!v[i]) {
				move(i);
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}

	public static void move(int idx) {
		v[idx] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[idx][i] == 1 && !v[i]) {
				move(i);
			}
		}
	}
}

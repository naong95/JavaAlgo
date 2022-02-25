package a0225;

import java.util.*;
import java.io.*;

public class Main_bj_7576_토마토_대전_5반_허진혁 {

	static int[] di = { -1, 1, 0, 0 };// 상하좌우
	static int[] dj = { 0, 0, -1, 1 };
	static int N, M, tomato[][], max;
	static LinkedList<int[]> q;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
					q.offer(new int[] { i, j, 1});
			}
		}
		max = 0;
		bfs();
		for (int[] is : tomato) {
			System.out.println(Arrays.toString(is));
		}
		max = check()? max - 1 : -1;
		System.out.println(max);
		br.close();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int[] current = q.poll();
			max = Math.max(max, current[2]);
			for (int d = 0; d < 4; d++) {
				int ni = current[0] + di[d];
				int nj = current[1] + dj[d];

				if (0 <= ni && ni < N && 0 <= nj && nj < M && tomato[ni][nj] == 0) {
					tomato[ni][nj] = current[2];
					q.offer(new int[] { ni, nj, current[2] + 1});
				}
			}
		}
	}
	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) return false;
			}
		}
		return true;
	}
}

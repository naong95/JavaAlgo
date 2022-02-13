package a0211;

import java.io.*;
import java.util.*;

public class Main_bj_2468_안전영역_대전_5반_허진혁 {
	static int[] di = { -1, 0, 1, 0 };// 상우하좌
	static int[] dj = { 0, 1, 0, -1 };
	static int[][] height;
	static int N, area;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_2468.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 지역의 크기
		height = new int[N][N];// 높이 저장 2차원 배열
		for (int i = 0; i < N; i++) {
			String[] h = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				height[i][j] = Integer.parseInt(h[j]);
			}
		}
		int maxArea = 1;
		for (int rain = 0; rain <= 100; rain++) {
			area = 0;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && height[i][j] > rain) {
						bfs(rain, i, j);
					} else
						continue;
				}
			}
			if (maxArea < area) {
				maxArea = area;
			}
		}

		System.out.println(maxArea);
		br.close();
	}

	static void bfs(int rain, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && height[ni][nj] > rain) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
				}
			}
			if (q.isEmpty())
				area++;
		}
	}
}

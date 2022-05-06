package study;

import java.util.*;
import java.io.*;

/*
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다.
(단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라.
단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
*/
public class Main_bj_1926_그림_대전_5반_허진혁 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static boolean[][] v;
	static int N, M, map[][], max, cnt, area;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1926.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j] && map[i][j] == 1) {
					cnt++;
					area = 1;
					dfs(i, j);
					max = Math.max(max, area);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		br.close();
	}

	public static void dfs(int i, int j) {
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || ni >= N || nj < 0 || nj >= M || v[ni][nj])
				continue;
			if (map[ni][nj] == 1) {
				area++;
				dfs(ni, nj);
			}
		}
	}
}
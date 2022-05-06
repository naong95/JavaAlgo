package study;
import java.util.*;
import java.io.*;
/*
첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100)
음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.
그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.
좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.

첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.
*/
public class Main_bj_1743_음식물피하기_대전_5반_허진혁 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static boolean[][] v;
	static int N, M, K, max, area;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1743.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = '*';
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j] && map[i][j] == '*') {
					area = 1;
					dfs(i, j);
					max = Math.max(max, area);
				}
			}
		}
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
			if (map[ni][nj] == '*') {
				area++;
				dfs(ni, nj);
			}
		}
	}
}
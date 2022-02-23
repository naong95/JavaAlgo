package a0223;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_대전_5반_허진혁 {
	/**
	 * 
	 */

	static int[] di = { -1, 0, 1, 0 };// 상좌하우
	static int[] dj = { 0, -1, 0, 1 };
	static boolean[][] v;
	static int N, sum, grid[][], time, baby[], levelExp[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		StringTokenizer st;
		time = 0;
		sum = 0;
		baby = new int[] { 0, 0 };// 아기상어의 좌표
		levelExp = new int[] { 2, 0 };// 아기상어의 크기와 경험치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				sum += grid[i][j];
				if (grid[i][j] == 9) {
					baby[0] = i;
					baby[1] = j;
				}
			}
		}
		for (int[] is : grid) {
			System.out.println(Arrays.toString(is));
		}

		v = new boolean[N][N];
		bfs(baby[0], baby[1]);
		System.out.println(time);
		br.close();
	}

	static boolean check() {// 현재 물고기들의 분포 상태를 체크하는 함수
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != 0 && grid[i][j] < levelExp[0]) {
					cnt++;
				}
			}
		}
		if (levelExp[0] <= (cnt + levelExp[1]))
			return true;
		return false;
	}

	static void bfs(int i, int j) {
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
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
					baby[0] = ni;
					baby[1] = nj;
					if (grid[ni][nj] < levelExp[0]) {// 다음 칸이 아기상어보다 작다면
						grid[i][j] = 0;
						grid[ni][nj] = 9;
						if (grid[ni][nj] != 0) {
							v[ni][nj] = true;
							levelExp[1]++;
							if (levelExp[0] == levelExp[1]) {
								levelExp[0]++;
								levelExp[1] = 0;
							}
						}
						if (check()) {
							time++;
						}
						q.offer(new int[] { ni, nj });
					} else if (grid[ni][nj] == levelExp[0]) {// 다음 칸이 아기상어와 같다면
						grid[i][j] = grid[ni][nj];
						grid[ni][nj] = 9;
						if (grid[ni][nj] != 0)
							v[ni][nj] = true;
						q.offer(new int[] { ni, nj });
						if (check()) {
							time++;
						}
					}
				}
			}
			if (q.isEmpty()) {

			}

		}
	}
}
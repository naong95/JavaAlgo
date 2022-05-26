package a.a0404;

import java.io.*;
import java.util.*;
/*
왜 최댓값보다 크게 나올까
뭘 잘못했는지 모르겠다
*/
public class Solution_d4_1868_파핑파핑지뢰찾기_대전_5반_허진혁 {

	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int N, ans;
	static char[][] map;
	static int[][] mine;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			mine = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			countMine();
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] == 0 && map[i][j] != '*') {
						click(i, j);
						ans++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] > 0 && map[i][j] != '*') {
						ans++;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}

	// . == 46
	// * == 42
	public static void click(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		mine[r][c] = -1;// 방문체크
		q.offer(new int[] {r, c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			for(int d = 0; d < 8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj < N && mine[ni][nj] != -1 && map[ni][nj] == '.') {
					mine[ni][nj] = -1;
					if(mine[ni][nj] == 0) q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	public static void countMine() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '.') {
					int cnt = 0;
					for(int d = 0; d < 8; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == '*') cnt++;
					}
					mine[i][j] = cnt;
				}
			}
		}
	}
}


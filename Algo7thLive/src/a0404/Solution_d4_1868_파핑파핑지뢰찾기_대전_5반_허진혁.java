package a0404;

import java.io.*;
import java.util.*;

public class Solution_d4_1868_파핑파핑지뢰찾기_대전_5반_허진혁 {

	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int N, cnt, ans;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 46 && !v[i][j])
						click(i, j);
				}
			}
			for (int[] ca : map)
				System.out.println(Arrays.toString(ca));
			System.out.println(ans);
		}
		br.close();
	}

	// . == 46
	// * == 42
	public static void click(int i, int j) {
		v[i][j] = true;
		cnt = 0;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + di[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
				if (map[ni][nj] == 42)
					cnt++;
			}
		}
		map[i][j] = cnt;
	}
}
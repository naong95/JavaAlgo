package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2606_바이러스_대전_5반_허진혁 {

	static int v, e;
	static int[][] map;
	static int[] virus;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2606.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());

		map = new int[v + 1][v + 1];
		virus = new int[v + 1];
		visit = new boolean[v + 1];
		StringTokenizer st;
		int r, c;
		for (int i = 0; i <= v; i++) {
			map[i][0] = i;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		dfs(map[1]);
		int ans = 0;
		for (int i : virus) {
			if (i == 1) {
				ans++;
			}
		}
		System.out.println(ans - 1);
		
		br.close();
	}
	public static void dfs(int[] arr) {
		virus[arr[0]] = 1;
		visit[arr[0]] = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1 && !visit[i]) {
				dfs(map[i]);
			}
		}
	}
}
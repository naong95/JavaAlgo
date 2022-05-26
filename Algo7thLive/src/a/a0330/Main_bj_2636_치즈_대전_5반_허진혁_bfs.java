package a.a0330;

import java.util.*;
import java.io.*;
/*
큐를 2개 사용해서
치즈를 담는 큐(1을 담아서 탐색)와 구멍을 담는 큐(0을 담아서 탐색)
없어지는 치즈는 주변에 구멍이 아닌 0이 있다면 다음에 0으로 변한다 -> 직관적으로 떠오른 생각이지만 탐색도 2개 만들어야 되고 너무 힘들다

탐색 하나로 처리할 수 있게 하자 -> 하나로 될 수 있을까 ? 된다
*/
public class Main_bj_2636_치즈_대전_5반_허진혁_bfs {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	
	static int R, C, map[][], cheese, count, turn;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2636.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		while(cheese != 0) {
			turn++;
			count = cheese;
			bfs();
		}
		
		sb.append(turn).append("\n").append(count);
		System.out.println(sb.toString());
		br.close();
	}
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		v = new boolean[R][C];
		v[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < R && 0 <= nj && nj < C && !v[ni][nj]) {
					if(map[ni][nj] == 1) {
						cheese--;
						map[ni][nj] = 0;
					} else if(map[ni][nj] == 0) {
						q.offer(new int[] {ni, nj});
					}
					v[ni][nj] = true;
				}
			}
		}
	}
}
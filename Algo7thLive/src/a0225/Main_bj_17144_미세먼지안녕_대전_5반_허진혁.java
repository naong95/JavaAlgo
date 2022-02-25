package a0225;

import java.util.*;
import java.io.*;

/*
1초 동안 아래 적힌 일이 순서대로 일어난다.

1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
	(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
	인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
	확산되는 양은 Ar,c/5이고 소수점은 버린다.
	(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
	
2. 공기청정기가 작동한다.
	공기청정기에서는 바람이 나온다.
	위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
	바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
	공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
*/
public class Main_bj_17144_미세먼지안녕_대전_5반_허진혁 {
	static int[] di = { -1, 1, 0, 0 };// 상하좌우
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17144.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] before = new int[R][C];
		int[][] after = new int[R][C];
		int[] cleaner = new int[2];
		Queue<int[]> dust = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
				if (before[i][j] == -1)
					cleaner[1] = i;
				if (before[i][j] > 0)
					dust.offer(new int[] { i, j });
				after[i][j] = before[i][j];
			}
		}
		cleaner[0] = cleaner[1] - 1;
		
		for (int t = 0; t < T; t++) {
			while (!dust.isEmpty()) {
				int cnt = 0;
				int[] now = dust.poll();
				for (int d = 0; d < 4; d++) {
					int ni = now[0] + di[d];
					int nj = now[1] + dj[d];
					if (0 <= ni && ni < R && 0 <= nj && nj < C && before[ni][nj] != -1) {
						after[ni][nj] += before[now[0]][now[1]] / 5;
						cnt++;
					}
				}
				after[now[0]][now[1]] -= (before[now[0]][now[1]] / 5) * cnt;
			}
			
			for(int i = cleaner[0] - 1; i >= 0; i--) {// 반시계 왼쪽 변
				after[i + 1][0] = after[i][0];
			}
			for(int i = 0; i < C - 1; i++) {// 반시계 위쪽 변
				after[0][i] = after[0][i + 1];
			}
			for(int i = 0; i < cleaner[0]; i++) {// 반시계 오른쪽 변
				after[i][C - 1] = after[i + 1][C - 1];
			}
			for(int i = C - 1; i > 0; i--) {// 반시계 아래쪽 변
				after[cleaner[0]][i] = after[cleaner[0]][i - 1];
			}
			after[cleaner[0]][0] = -1;
			after[cleaner[0]][1] = 0;
			
			for(int i = cleaner[1]; i < R - 1; i++) {// 시계 왼쪽 변
				after[i][0] = after[i + 1][0];
			}
			for(int i = 0; i < C - 1; i++) {// 시계 아래쪽 변
				after[R - 1][i] = after[R - 1][i + 1];
			}
			for(int i = R - 1; i > cleaner[1]; i--) {// 시계 오른쪽 변
				after[i][C - 1] = after[i - 1][C - 1];
			}
			for(int i = C - 1; i > 0; i--) {// 시계 위쪽 변
				after[cleaner[1]][i] = after[cleaner[1]][i - 1];
			}
			after[cleaner[1]][0] = -1;
			after[cleaner[1]][1] = 0;
			
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (after[i][j] > 0)
						dust.offer(new int[] { i, j });
					before[i][j] = after[i][j];
				}
			}
		}
		int sum = 2;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += after[i][j];
			}
		}
		System.out.println(sum);
		br.close();
	}
}

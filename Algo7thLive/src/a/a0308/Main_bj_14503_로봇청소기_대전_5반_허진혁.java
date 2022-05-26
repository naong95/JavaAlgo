package a.a0308;

import java.util.*;
import java.io.*;

/*
1. 현재 위치를 청소한다.
2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
	왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
*/
public class Main_bj_14503_로봇청소기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14503.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 세로
		int M = sc.nextInt();// 가로

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map[r][c] = 2;
		int nr = 0;
		int nc = 0;
		int cnt = 0;

		while (true) {
			if (map[r - 1][c] != 0 && map[r][c + 1] != 0 && map[r + 1][c] != 0 && map[r][c - 1] != 0) {
				int br = 0;
				int bc = 0;
				if (d == 0) {
					br = r + 1;
					bc = c;
				} else if (d == 1) {
					br = r;
					bc = c - 1;
				} else if (d == 2) {
					br = r - 1;
					bc = c;
				} else {
					br = r;
					bc = c + 1;
				}
				if (map[br][bc] == 1)
					break;
				r = br;
				c = bc;
			}
			if (d == 0) {
				nr = r;
				nc = c - 1;
			} else if (d == 1) {
				nr = r - 1;
				nc = c;
			} else if (d == 2) {
				nr = r;
				nc = c + 1;
			} else {
				nr = r - 1;
				nc = c;
			}
			if (map[nr][nc] == 1)
				d = (d == 4) ? 0 : d + 1;
			else if (map[nr][nc] == 0) {
				d = (d == 0) ? 3 : d - 1;
				map[nr][nc] = 2;
				cnt++;
				r = nr;
				c = nc;
			}

			System.out.println("청소기의 현재 위치는: " + r + ", " + c);
			System.out.println("청소기는 현재 " + d + "를 보고 있습니다");
			for (int[] is : map) {
				System.out.println(Arrays.toString(is));
			}
		}
		System.out.println(cnt);

		sc.close();
	}
}
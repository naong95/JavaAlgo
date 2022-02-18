package a0218;

import java.io.*;
import java.util.*;

public class Solution_d4_1861_정사각형방_대전_5반_허진혁 {
	/**
	 * dfs 안에 답을 찾아가는 조건문이나 대입 등을 한 번에 처리하면 편하다
	 */
	static int N, res, newRoom;
	static int[] di = { -1, 0, 1, 0 };// 4방 탐색
	static int[] dj = { 0, 1, 0, -1 };
	static int[][] room;
	static boolean[][] v;

	public static void dfs(int cnt, int i, int j, int roomNum) {
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (0 <= ni && ni < N && 0 <= nj && nj < N)// 범위 안에서
				if (room[ni][nj] - room[i][j] == 1 && !v[ni][nj]) {// 다음 방이 1이 크고 방문하지 않았다면
					dfs(cnt + 1, ni, nj, roomNum);
				}
		}

		if (res < cnt) {// 결과보다 새로운 카운트가 더 크면
			res = cnt;// 갱신
			newRoom = roomNum;// 그 때의 방 번호 대입
		}
		if (res == cnt) {// 결과와 카운트가 같다면
			newRoom = Math.min(newRoom, roomNum);// 방 번호가 더 낮은 것 대입
		}
		v[i][j] = false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 방이 들어갈 수 있는 정사각형 배열의 한 변의 길이
			room = new int[N][N];
			v = new boolean[N][N];

			res = 0;
			newRoom = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {// 모든 방에서 다 dfs 해보기
				for (int j = 0; j < N; j++) {
					dfs(1, i, j, room[i][j]);
				}
			}
			System.out.println("#" + tc + " " + newRoom + " " + res);

		}
		sc.close();
	}
}
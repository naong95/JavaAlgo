package a0217.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_1987_알파벳_대전_5반_허진혁 {
	/**
	 * 다음 칸이 방문한 적이 있는 알파벳이라면 바로 리턴
	 * 
	 * 뭐가 잘못된거지;;
	 */
	static int r, c, res, alphabet[][];// 행, 열, 알파벳을 담는 배열(정수형으로 해야 방문체크 시에 인덱스로 활용하기 좋다: A => 0, Z => 25)
	static boolean[] v;// 방문여부 체크

	static int[] di = { 0, 1, 0, -1 };// 우하좌상
	static int[] dj = { 1, 0, -1, 0 };// 자신 기준 상하좌우 4방향으로 전진

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		alphabet = new int[r][c];
		v = new boolean[26];// 알파벳은 26개로 정해져 있으므로
		for (int i = 0; i < r; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				String alpha = line[j];
				alphabet[i][j] = alpha.charAt(0) - 'A';// 'A'를 빼서 정수형으로
			}
		}
		next(0, 0, 0);
		System.out.println(res);

		br.close();
	}

	static void next(int i, int j, int cnt) {// 말 전진
		if (v[alphabet[i][j]]) {// 방문한 알파벳이라면
			res = Math.max(res, cnt);// 현재 값과 최댓값 비교 후
			return;// 리턴
		} else {// 방문하지 않은 알파벳이라면
			v[alphabet[i][j]] = true;// 방문처리 해주고
			for (int d = 0; d < 4; d++) {// 4방 탐색
				int ni = i + di[i];
				int nj = j + dj[i];

				if (0 <= ni && ni < r && 0 <= nj && nj < c) {
					next(ni, nj, cnt + 1);
				}
			}
			v[alphabet[i][j]] = false;// 방문처리 해제
		}
	}
}
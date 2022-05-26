package a.a0223;

import java.io.*;
import java.util.*;

public class Main_bj_10026_적록색약dfs_대전_5반_허진혁 {
	/**
	 * RGB 3가지 색이 몇 개의 영역으로 나뉘어 있는지
	 * 
	 * 적록색약인 사람은 R과 G를 같은 색으로 본다
	 * 
	 * 안전 영역
	 */

	static int[] di = { -1, 0, 1, 0 };// 상우하좌
	static int[] dj = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int N, area[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] pic = new char[N][N];
		char[][] pic2 = new char[N][N];
		String line = "";
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				pic[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pic[i][j] == 'G')
					pic2[i][j] = 'R';
				else
					pic2[i][j] = pic[i][j];
			}
		}
//		for (char[] p : pic) {
//			System.out.println(Arrays.toString(p));
//		}
//		for (char[] p : pic2) {
//			System.out.println(Arrays.toString(p));
//		}

		for (int k = 0; k < 2; k++) {
			v = new boolean[N][N];
			area = new int[3];// R,G,B
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && k == 0) {
						dfs(pic, i, j);
						if (pic[i][j] == 'R')
							area[0]++;
						else if (pic[i][j] == 'G')
							area[1]++;
						else if (pic[i][j] == 'B')
							area[2]++;
					} else if (!v[i][j] && k == 1) {
						dfs(pic2, i, j);
						if (pic2[i][j] == 'R')
							area[0]++;
						else if (pic2[i][j] == 'B')
							area[1]++;
					}
				}
			}
			System.out.print(area[0] + area[1] + area[2] + " ");
		}

		br.close();
	}

	static void dfs(char[][] picture, int i, int j) {
		v[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && picture[i][j] == picture[ni][nj]) {
//				v[ni][nj] = true;
				dfs(picture, ni, nj);
			}
		}
	}

}
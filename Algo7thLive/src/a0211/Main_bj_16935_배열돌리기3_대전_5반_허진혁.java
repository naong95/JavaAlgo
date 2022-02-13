package a0211;

import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3_대전_5반_허진혁 {
	static int I[][], O[][]; // 입력 배열, 출력 배열
	static int N, M, R;// 세로, 가로, 연산 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_16935.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmr = br.readLine().split(" ");
		N = Integer.parseInt(nmr[0]);
		M = Integer.parseInt(nmr[1]);
		R = Integer.parseInt(nmr[2]);
		int size = Math.max(N, M);
		I = new int[size][size];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				I[i][j] = Integer.parseInt(s[j]);
			}
		}
		for (int i = 0; i < R; i++) {

		}
	}

	static void UD() {
		O = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				O[N - i - 1][j] = I[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				I[i][j] = O[i][j];
			}
		}
	}

	static void LR() {
		O = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				O[i][M - j - 1] = I[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				I[i][j] = O[i][j];
			}
		}
	}

	static void R90() {
		O = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				O[j][N - 1 - i] = I[i][j];
			}
		}
	}

	static void L90() {
		O = new int[M][N];
	}

	static void gridR() {
		O = new int[N][M];
	}

	static void gridL() {
		O = new int[N][M];
	}
}

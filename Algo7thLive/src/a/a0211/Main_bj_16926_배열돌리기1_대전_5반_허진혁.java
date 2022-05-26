package a.a0211;

import java.io.*;
import java.util.*;

public class Main_bj_16926_배열돌리기1_대전_5반_허진혁 {
	static int I[][], O[][]; // 입력 배열, 출력 배열
	static boolean v[][];
	static int N, M, R;// 세로, 가로, 회전 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_16926.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmr = br.readLine().split(" ");
		N = Integer.parseInt(nmr[0]);
		M = Integer.parseInt(nmr[1]);
		R = Integer.parseInt(nmr[2]);
		I = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				I[i][j] = Integer.parseInt(s[j]);
			}
		}
		//회전회오리();

		for (int[] is : O) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

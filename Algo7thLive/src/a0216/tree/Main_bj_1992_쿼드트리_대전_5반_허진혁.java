package a0216.tree;

import java.io.*;
import java.util.*;

public class Main_bj_1992_쿼드트리_대전_5반_허진혁 {
	/**
	 * 마트료시카
	 * 
	 * 현재 영역에 다른 원소가 있으면 압축이 불가능
	 * 
	 * 그 경우에 한 번 더 사분면을 나눈다.
	 */
	static int size, movie[][];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 영상의 원본 크기

		movie = new int[N][N];// 영상 정보가 담기는 배열
		for (int i = 0; i < N; i++) {// 정보 배열에 저장
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				movie[i][j] = Integer.parseInt(str[j]);
			}
		}
		System.out.println(N);
		for (int[] is : movie) {// 담긴 정보 확인
			System.out.println(Arrays.toString(is));
		}
		zip(N, 0, 0);

		br.close();
	}

	public static void zip(int size, int r, int c) {
		boolean flag;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < j + size; j++) {
				if (movie[r][c] != movie[i][j]) {
					flag = true;
					break;
				}
			}
		}

	}
}
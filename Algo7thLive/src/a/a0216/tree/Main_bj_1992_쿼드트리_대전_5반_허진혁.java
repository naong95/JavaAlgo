package a.a0216.tree;

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
	static StringBuilder sb = new StringBuilder();

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
//		for (int[] is : movie) {// 담긴 정보 확인
//			System.out.println(Arrays.toString(is));
//		}
		zip(N, 0, 0);

		System.out.println(sb);
		br.close();
	}

	public static void zip(int size, int r, int c) {
		boolean flag = false;// 한 번 더 탐색 해야 되는지 여부 true면 괄호 열고 찍고 재귀

		for (int i = r; i < r + size; i++) {// 해당 영역 전체를 돌다가
			for (int j = c; j < c + size; j++) {
				if (movie[r][c] != movie[i][j]) {// 좌상(시작)과 다른 원소가 있다면
					flag = true;// 한 번 더 탐색을 true로 만들고 중단
					break;
				}
			}
		}
		if (!flag) {
			sb.append(movie[r][c]);
			return;
		}
		int nSize = size / 2;
		sb.append("(");
		zip(nSize, r, c);// 시작
		zip(nSize, r, c + nSize);// 우
		zip(nSize, r + nSize, c);// 하
		zip(nSize, r + nSize, c + nSize);// 우하

		sb.append(")");

	}

}

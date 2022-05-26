package a.a0209;

import java.io.*;
import java.util.*;

public class Solution_d4_1210_Ladder1_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_d4_1210.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] ladder = new int[100][100];// 사다리를 담을 2차원 배열
			int T = Integer.parseInt(br.readLine());
			int endI = 0;
			int endJ = 0;
			for (int i = 0; i < 100; i++) {// 사다리를 담아오기
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						endI = i;
						endJ = j;
					}
				}
			}
			endI--;
			while (endI > 0) {
				if (endJ > 0 && ladder[endI][endJ - 1] == 1) {// 좌
					ladder[endI][--endJ]--;
				} else if (endJ < 99 && ladder[endI][endJ + 1] == 1) {// 우
					ladder[endI][++endJ]--;
				} else {// 상
					ladder[--endI][endJ]--;
				}
			}
			sb.append("#").append(test_case).append(" ").append(endJ).append("\n");

		}
		System.out.println(sb);
		br.close();
	}
}

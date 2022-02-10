package a0203.iorecursive;

import java.io.*;
import java.util.*;

public class Solution_d2_1954_달팽이숫자_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1954.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			int next = n;// 진행 횟수
			int row = 0;// 세로
			int col = -1;// 가로
			int value = 1;// 채워지는 값
			int d = 1;// 변화량
			for (int i = n; i > 0; i--) {
				// 가로 진행
				for (int j = 0; j < next; j++) {
					col += d;// 가로로 진행(d가 양수면 오른쪽으로 음수면 왼쪽으로)
					arr[row][col] = value;// 값 채우기
					value++;// 값 1 증가
				}

				next--;// 진행 횟수 하나 줄이기

				// 세로 진행
				for (int j = 0; j < next; j++) {
					row += d;// 세로로 진행(d가 양수면 아래로 음수면 위로)
					arr[row][col] = value;
					value++;
				}

				d *= (-1); // 가로, 세로의 방향 변경
			}
			System.out.println("#" + tc);
			for (int[] is : arr) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}

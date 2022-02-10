package a0210.treebfsdfs;

import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_2563.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 색종이의 개수
		int[][] grid = new int[100][100];// 도화지
		int[][] xy = new int[N][2];
		int xi = 0;// 도화지에서의 인덱스
		int yi = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());

			xi = xy[i][0] - 1;// 배열에서 인덱스이므로 -1
			yi = xy[i][1] - 1;

			// 색종이는 모두 10칸짜리 정사각형이므로
			for (int j = xi; j < xi + 10; j++) {// 세로 10칸
				for (int k = yi; k < yi + 10; k++) {// 가로 10칸
					grid[j][k] = 1;// 1로 바꿔준다
				}
			}
		}
		int area = 0;// 색종이의 총 넓이
		for (int[] is : grid) {
			for (int i : is) {
				area += i;// 1로 변한(색종이가 덮힌) 곳을 전부 더해준다
			}
		}
		System.out.println(area);

		br.close();
	}
}

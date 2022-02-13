package a0211;

import java.io.*;
import java.util.*;

public class Main_bj_13300_방배정_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_13300.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("res/input_bj_13300.txt"));
		Scanner sc = new Scanner(System.in);
		/**
		 * 개수 세기
		 */
		int[][] student = new int[2][6];// 성별, 학년으로 되어 있는 배열
		int N = sc.nextInt();// 학생 수
		int R = sc.nextInt();// 한 방에 배정 학생 수
		int res = 0;
		for (int i = 0; i < N; i++) {// 해당 성별, 학년의 칸을 1 증가
			int s = sc.nextInt();
			int g = sc.nextInt();

			student[s][g - 1]++;
		}

//		for (int[] is : student) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (student[i][j] % R == 0) {// 방 배정 인원의 배수라면 R명당 방 1개
					res += student[i][j] / R;
				} else
					res += student[i][j] / R + 1;// R로 나눴을 때 나머지가 있다면 나머지 학생 들어갈 방 +1
			}
		}

		System.out.println(res);
		sc.close();
	}
}

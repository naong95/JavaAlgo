package a.a0211;

import java.io.*;
import java.util.*;

public class Main_bj_14696_딱지놀이_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_14696.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("res/input_bj_14696.txt"));
		Scanner sc = new Scanner(System.in);
		/**
		 * 별 > 동글 > 네모 > 세모 개수를 세서 배열에 저장하고 비교
		 */
		int round = sc.nextInt();

		for (int r = 0; r < round; r++) {
			char winner = 'D';
			int[] aCount = new int[5];// 모양 개수(4) + 1로 만들어서 인덱스가 그 모양을 의미하도록
			int[] bCount = new int[5];

			int a = sc.nextInt();// A의 모양 개수
			for (int i = 0; i < a; i++) {
				aCount[sc.nextInt()]++;
			}
			int b = sc.nextInt();// B의 모양 개수
			for (int i = 0; i < b; i++) {
				bCount[sc.nextInt()]++;
			}
			for (int i = 4; i >= 1; i--) {
				if (aCount[i] == bCount[i]) {
					continue;
				} else if (aCount[i] > bCount[i]) {
					winner = 'A';
					break;
				} else if (aCount[i] < bCount[i]) {
					winner = 'B';
					break;
				}
			}

			System.out.println(Arrays.toString(aCount) + " vs " + Arrays.toString(bCount) + "winner: " + winner);
		}

		sc.close();
	}
}

package a.a0207;

import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트_대전_5반_허진혁 {

	static int T, size, mc, max, score[], calo[];
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_5215.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			size = sc.nextInt();
			mc = sc.nextInt();
			isSelected = new boolean[size];
			score = new int[size];
			calo = new int[size];

			for (int i = 0; i < size; i++) {
				score[i] = sc.nextInt();
				calo[i] = sc.nextInt();
			}

			max = 0;
			hamburger(0, 0, 0);
			System.out.println("#" + test_case + " " + max);

		}
		sc.close();
	}

	public static void hamburger(int cnt, int scr, int cal) {
		if (cal > mc)
			return;
		if (cal <= mc)
			max = Math.max(max, scr);
		if (cnt == size)
			return;
		
		hamburger(cnt + 1, scr + score[cnt], cal + calo[cnt]);
		hamburger(cnt + 1, scr, cal);

	}

}

package a0204;

import java.io.*;
import java.util.*;

public class Solution_d2_2001_파리퇴치_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int M = Integer.MIN_VALUE;
			int total = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int fly[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fly[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					total = 0;

					for (int k = 0; k < m; k++) {
						for (int l = 0; l < m; l++) {
							total += fly[i + k][j + l];
							if (M < total)
								M = total;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + M);
		}
		sc.close();
	}

}

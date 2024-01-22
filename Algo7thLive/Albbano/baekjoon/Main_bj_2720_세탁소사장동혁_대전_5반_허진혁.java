package baekjoon;

import java.util.*;
import java.io.*;

/*
25 10 5 1
*/
public class Main_bj_2720_세탁소사장동혁_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2720.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");

		while (n-- > 0) {
			int c = Integer.parseInt(br.readLine());
			int[] coin = new int[4];

			while (c > 0) {
				int k = 0;
				if (c >= 25) {
					k = c / 25;
					c -= 25 * k;
					coin[0] = k;
				} else if (c >= 10) {
					k = c / 10;
					c -= 10 * k;
					coin[1] = k;
				} else if (c >= 5) {
					k = c / 5;
					c -= 5 * k;
					coin[2] = k;
				} else {
					k = c;
					c -= k;
					coin[3] = k;
				}
			}
			for (int i = 0; i < 4; i++) {
				sb.append(coin[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
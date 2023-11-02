package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10798_세로읽기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10798.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(new InputStreamReader(System.in));

		char[][] map = new char[5][15];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				map[i][j] = '*';
			}
		}

		for (int i = 0; i < 5; i++) {
			char[] ca = br.readLine().toCharArray();
			for (int j = 0; j < ca.length; j++) {
				map[i][j] = ca[j];
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == '*') {
					continue;
				} else {
					sb.append(map[j][i]);
				}
			}
		}
		System.out.println(sb.toString().trim());

		br.close();
	}
}
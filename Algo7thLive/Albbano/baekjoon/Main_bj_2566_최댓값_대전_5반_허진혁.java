package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2566_최댓값_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2566.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[9][9];
		int r = -1;
		int c = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max <= map[i][j]) {
					max = map[i][j];
					r = i;
					c = j;
				}
			}
		}
		r++;
		c++;
		System.out.println(max);
		System.out.println(r + " " + c);

		br.close();
	}
}
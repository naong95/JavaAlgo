package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1463_1로만들기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] min = new int[1000001];
		min[2] = 1;
		min[3] = 1;
		for (int i = 4; i <= n; i++) {
			if (i % 6 == 0) {
				min[i] = Math.min(min[i / 3], Math.min(min[i / 2], min[i - 1])) + 1;
			} else if (i % 3 == 0) {
				min[i] = Math.min(min[i / 3], min[i - 1]) + 1;
			} else if (i % 2 == 0) {
				min[i] = Math.min(min[i / 2], min[i - 1]) + 1;
			} else {
				min[i] = min[i - 1] + 1;
			}
		}
		System.out.println(min[n]);
		br.close();
	}
}
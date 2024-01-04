package baekjoon;

import java.util.*;
import java.io.*;

/*
6 12 18 24
*/
public class Main_bj_2292_벌집_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int m = 1;
		int cnt = 1;
		while (m < n) {
			m += 6 * cnt;
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}
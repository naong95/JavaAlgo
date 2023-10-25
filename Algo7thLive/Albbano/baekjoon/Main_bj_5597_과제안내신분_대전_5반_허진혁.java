package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_5597_과제안내신분_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_5597.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] check = new int[31];
		check[0] = 1;
		StringTokenizer st;
		for (int i = 0; i < 28; i++) {
			st = new StringTokenizer(br.readLine());
			check[Integer.parseInt(st.nextToken())]++;
		}
		for (int i = 0; i < 31; i++) {
			if (check[i] == 0) {
				System.out.println(i);
			}
		}

		br.close();
	}
}
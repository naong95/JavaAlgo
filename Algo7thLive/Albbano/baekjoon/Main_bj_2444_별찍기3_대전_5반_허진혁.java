package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2444_별찍기3_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2444.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = 2 * N - 1;
		for (int i = 1; i < N; i++) {
			for (int j = N - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; i++) {
				System.out.print("*");
			}
			for (int j = N - i; j > 0; j--) {
				System.out.print(" ");
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print("*");
		}

		br.close();
	}
}
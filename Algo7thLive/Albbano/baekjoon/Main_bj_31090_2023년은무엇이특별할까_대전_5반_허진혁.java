package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_31090_2023년은무엇이특별할까_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31090.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if ((m + 1) % (m % 100) == 0) {
				System.out.println("Good");
			} else {
				System.out.println("Bye");
			}
		}

		br.close();
	}
}
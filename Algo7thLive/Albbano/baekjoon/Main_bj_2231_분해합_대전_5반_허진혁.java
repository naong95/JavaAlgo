package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2231_분해합_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = 1;
		int total = 0;
		String itos;
		char[] arr;

		while (m != n) {
			total = 0;
			itos = Integer.toString(m);
			arr = itos.toCharArray();

			for (int i = 0; i < arr.length; i++) {
				total += arr[i] - '0';
			}
			total += m;
			if (total == n)
				break;
			else
				m++;
		}
		if (total == n) {
			System.out.println(m);
		} else {
			System.out.println(0);
		}

		br.close();
	}
}
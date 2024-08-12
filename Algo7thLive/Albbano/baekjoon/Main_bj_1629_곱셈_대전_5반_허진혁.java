package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1629_곱셈_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1629.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long result = modularExponetiation(a, b, c);
		System.out.println((int) result);

		br.close();
	}

	public static long modularExponetiation(long base, long exponent, long modulus) {
		long result = 1;
		base = base % modulus;

		while (exponent > 0) {
			if ((exponent & 1) == 1) {
				result = (result * base) % modulus;
			}

			exponent = exponent >> 1;
			base = (base * base) % modulus;
		}
		return result;
	}
}
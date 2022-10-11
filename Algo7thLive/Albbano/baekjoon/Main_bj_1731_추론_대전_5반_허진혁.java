package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1731_추론_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1731.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		int q = -1;
		if (numbers[1] % numbers[0] == 0) {
			if (numbers[2] % numbers[1] == 0) {
				q = numbers[2] / numbers[1];
				System.out.println(numbers[N - 1] * q);
			} else {
				q = numbers[2] - numbers[1];
				System.out.println(numbers[N - 1] + q);
			}
		} else {
			q = numbers[2] - numbers[1];
			System.out.println(numbers[N - 1] + q);
		}

		br.close();
	}
}
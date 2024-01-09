package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1929_소수구하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("");
		int[] arr = new int[e + 1];

		for (int i = 2; i < e + 1; i++) {
			arr[i] = i;
		}
		for (int i = 2; i < e + 1; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j < e + 1; j += i) {
				arr[j] = 0;
			}
		}
		for (int i = s; i < e + 1; i++) {
			if (arr[i] != 0) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
}
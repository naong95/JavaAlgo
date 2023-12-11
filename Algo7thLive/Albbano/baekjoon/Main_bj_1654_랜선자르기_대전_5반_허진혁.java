package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1654_랜선자르기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		max++;

		long min = 0;
		long mid = 0;

		while (min < max) {
			mid = (max + min) / 2;
			long count = 0;

			for (int i : arr) {
				count += i / mid;
			}

			if (count < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
		br.close();
	}
}
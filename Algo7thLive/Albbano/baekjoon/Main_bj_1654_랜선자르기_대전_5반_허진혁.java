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
		int ans = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int d = arr[0];

		while (ans < n) {
			ans = 0;
			d--;
			for (int i : arr) {
				ans += i / d;
			}
		}

		System.out.println(d);
		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_15649_N과M_대전_5반_허진혁 {

	static boolean[] v;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_15649.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		v = new boolean[n];
		arr = new int[m];

		next(0, n, m);

		br.close();
	}

	public static void next(int cnt, int n, int m) {
		if (cnt == m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				arr[cnt] = i + 1;
				next(cnt + 1, n, m);

				v[i] = false;
			}
		}

		return;
	}
}
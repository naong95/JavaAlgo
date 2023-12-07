package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2798_블랙잭_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2798.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] > m) {
						continue;
					} else {
						if (m - (arr[i] + arr[j] + arr[k]) < m - ans) {
							ans = arr[i] + arr[j] + arr[k];
						}
					}

				}
			}
		}
		System.out.println(ans);
		
		br.close();
	}
}
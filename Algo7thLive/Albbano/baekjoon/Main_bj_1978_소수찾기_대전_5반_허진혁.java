package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1978_소수찾기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1978.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int j = 1; j < p; j++) {
				if (p % j == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
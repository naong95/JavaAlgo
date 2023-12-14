package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11047_동전0_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int ans = 0;

		for (int i = n - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			if (k == 0) {
				break;
			}
			if (arr[i] > k) {
				continue;
			}
			int cnt = k / arr[i];
			k -= arr[i] * cnt;
			ans += cnt;
		}
		System.out.println(ans);
		
		br.close();
	}
}
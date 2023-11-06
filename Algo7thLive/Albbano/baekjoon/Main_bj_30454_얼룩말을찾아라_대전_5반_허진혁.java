package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30454_얼룩말을찾아라_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30454.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] zArray = new int[n];
		int max = 0;
		int cnt = 0;
		char[] zebra;
		for (int i = 0; i < n; i++) {
			cnt = 0;
			zebra = br.readLine().toCharArray();
			if (zebra[0] == '1') {
				cnt++;
			}
			for (int j = 1; j < l; j++) {
				if (zebra[j - 1] == '0' && zebra[j] == '1') {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
			zArray[i] = cnt;
		}
		cnt = 0;
		for (int i : zArray) {
			if (i == max) {
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(max).append(" ").append(cnt);
		System.out.println(sb.toString());

		br.close();
	}
}
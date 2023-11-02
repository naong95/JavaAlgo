package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_3003_킹퀸룩비숍나이트폰_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_3003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] set = { 1, 1, 2, 2, 2, 8 };
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++) {
			set[i] -= Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 6; i++) {
			sb.append(set[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}
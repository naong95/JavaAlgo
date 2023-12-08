package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30868_개표_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int votes = 0;
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			votes = Integer.parseInt(br.readLine());
			for (int j = 0; j < votes / 5; j++) {
				sb.append("++++ ");
			}
			for (int j = 0; j < votes % 5; j++) {
				sb.append("|");
			}
			if (i != n - 1) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString().trim());

		br.close();
	}
}
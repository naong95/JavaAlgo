package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10807_개수세기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10807.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (v == Integer.parseInt(st.nextToken())) {
				answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
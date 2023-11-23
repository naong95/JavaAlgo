package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2908_상수_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2908.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		char[] arr = st.nextToken().toCharArray();
		StringBuilder sb = new StringBuilder("");

		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		int a = Integer.parseInt(sb.toString());
		arr = st.nextToken().toCharArray();
		sb = new StringBuilder("");
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		int b = Integer.parseInt(sb.toString());

		System.out.println(Math.max(a, b));
		br.close();
	}
}
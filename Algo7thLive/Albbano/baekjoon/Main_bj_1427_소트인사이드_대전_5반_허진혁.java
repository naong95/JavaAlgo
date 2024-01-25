package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1427_소트인사이드_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1427.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("");

		Arrays.sort(arr, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder("");

		for (String s : arr) {
			sb.append(s);
		}
		System.out.println(sb.toString());
		br.close();
	}
}
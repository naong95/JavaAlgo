package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10989_수정렬하기3_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder("");
		for (int i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());

		br.close();
	}
}
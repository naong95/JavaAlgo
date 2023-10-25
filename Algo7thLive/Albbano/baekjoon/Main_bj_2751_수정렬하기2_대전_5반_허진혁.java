package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2751_수정렬하기2_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2751.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			al.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(al);
		for (int value : al) {
			sb.append(value).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
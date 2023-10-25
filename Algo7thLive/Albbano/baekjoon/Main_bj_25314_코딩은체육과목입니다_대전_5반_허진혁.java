package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_25314_코딩은체육과목입니다_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_25314.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		b /= 4;
		for (int i = 0; i < b; i++) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb.toString());

		br.close();
	}
}
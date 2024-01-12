package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2745_진법변환_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2745.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String s = st.nextToken();
		int n = Integer.parseInt(st.nextToken());

		System.out.println(Integer.parseInt(s, n));
		br.close();
	}
}
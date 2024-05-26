package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_31922_이대회는이제제겁니다_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31922.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		if (A + C > P) {
			System.out.println(A + C);
		} else
			System.out.println(P);

		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_31403_APBMC_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		int n = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);

		StringBuilder sb = new StringBuilder("");

		sb.append(A).append(B);

		int N = Integer.parseInt(sb.toString()) - Integer.parseInt(C);

		sb = new StringBuilder();

		sb.append(n).append("\n").append(N);

		System.out.println(sb.toString());
		br.close();
	}
}
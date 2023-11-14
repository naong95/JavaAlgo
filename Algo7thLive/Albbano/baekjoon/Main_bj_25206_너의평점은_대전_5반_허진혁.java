package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_25206_너의평점은_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_25206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double total = 0;
		double ttotal = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			double time = Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			if (s.equals("A+")) {
				total += time * 4.5;
				ttotal += time;
			} else if (s.equals("A0")) {
				total += time * 4;
				ttotal += time;
			} else if (s.equals("B+")) {
				total += time * 3.5;
				ttotal += time;
			} else if (s.equals("B0")) {
				total += time * 3;
				ttotal += time;
			} else if (s.equals("C+")) {
				total += time * 2.5;
				ttotal += time;
			} else if (s.equals("C0")) {
				total += time * 2;
				ttotal += time;
			} else if (s.equals("D+")) {
				total += time * 1.5;
				ttotal += time;
			} else if (s.equals("D0")) {
				total += time * 1;
				ttotal += time;
			} else if (s.equals("F")) {
				ttotal += time;
			} else {
				continue;
			}
		}
		System.out.println(total / ttotal);

		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1874_스택수열_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1874.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");

		Stack<Integer> s = new Stack<>();
		int start = 0;

		while (n-- > 0) {
			int value = Integer.parseInt(br.readLine());

			if (start < value) {

				for (int i = start + 1; i < value + 1; i++) {
					s.push(i);
					sb.append("+").append("\n");
				}
				start = value;
			}

			else if (s.peek() != value) {
				System.out.println("NO");
				return;
			}

			s.pop();
			sb.append("-").append("\n");

		}

		System.out.println(sb.toString());
		br.close();
	}
}
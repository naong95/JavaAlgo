package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11723_집합_대전_5반_허진혁 {

	static Set<Integer> s;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11723.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		String input = "";
		int num = 0;
		s = new HashSet<>();
		sb = new StringBuilder("");

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input = st.nextToken();
			if (input.equals("all") || input.equals("empty")) {
				num = 0;
				cal(input, num);
				continue;
			}
			num = Integer.parseInt(st.nextToken());

			cal(input, num);
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static void cal(String input, int num) {
		if (input.equals("add")) {
			s.add(num);
		} else if (input.equals("remove")) {
			if (s.contains(num)) {
				s.remove(num);
			}
		} else if (input.equals("check")) {
			if (s.contains(num)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		} else if (input.equals("toggle")) {
			if (s.contains(num)) {
				s.remove(num);
			} else {
				s.add(num);
			}
		} else if (input.equals("all")) {
			s.clear();
			for (int i = 1; i < 21; i++) {
				s.add(i);
			}
		} else if (input.equals("empty")) {
			s.clear();
		}
	}
}
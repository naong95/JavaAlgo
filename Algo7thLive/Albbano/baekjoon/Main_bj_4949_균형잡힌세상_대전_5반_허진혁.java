package baekjoon;

import java.util.*;
import java.io.*;

/*
yes
yes
no
no
no
yes
yes
*/
public class Main_bj_4949_균형잡힌세상_대전_5반_허진혁 {
	public static String check(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '[') {
				s.push(arr[i]);
			} else if (arr[i] == ')') {
				if (s.isEmpty() || s.peek() != '(') {
					return ("no");
				} else {
					s.pop();
				}
			} else if (arr[i] == ']') {
				if (s.isEmpty() || s.peek() != '[') {
					return ("no");
				} else {
					s.pop();
				}
			}
		}
		if (s.isEmpty()) {
			return ("yes");
		} else {
			return ("no");
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder("");
		String str;

		while (true) {
			str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			sb.append(check(str)).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
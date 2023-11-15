package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_9012_괄호_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr;
		Stack<Character> s;
		for (int i = 0; i < n; i++) {
			arr = br.readLine().toCharArray();
			if (arr[0] == ')') {
				System.out.println("NO");
				continue;
			}
			s = new Stack<>();
			exit: for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					s.push(arr[j]);
				} else {
					if (s.isEmpty()) {
						s.push(arr[j]);
						break exit;
					} else {
						s.pop();
					}
				}
			}
			if (s.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		br.close();
	}
}
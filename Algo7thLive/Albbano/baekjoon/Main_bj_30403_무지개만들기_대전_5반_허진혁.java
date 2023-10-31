package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30403_무지개만들기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lcheck = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder("");
		Set<Character> s = new HashSet<>();
		for (char c : arr) {
			if (s.add(c)) {
				sb.append(c);
			}
		}
		lcheck = 0;
		int ucheck = 0;
		if (sb.toString().contains("bgiorvy")) {
			lcheck = 1;
		}
		if (sb.toString().contains("BGIORVY")) {
			ucheck = 1;
		}

		if (lcheck == 1 && ucheck == 1) {
			System.out.println("YeS");
		} else if (lcheck == 1) {
			System.out.println("yes");
		} else if (ucheck == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO!");
		}

		br.close();
	}
}
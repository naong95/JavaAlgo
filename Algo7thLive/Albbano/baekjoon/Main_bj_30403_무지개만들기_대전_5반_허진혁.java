package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30403_무지개만들기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		char[] arr = br.readLine().toCharArray();
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder("");
		Set<Character> s = new HashSet<>();
		for (char c : arr) {
			if (s.add(c)) {
				sb.append(c);
			}
		}
		if (sb.toString().contains("BGIORVY") && sb.toString().contains("bgiorvy")) {
			System.out.println("YeS");
		} else if (sb.toString().contains("bgiorvy")) {
			System.out.println("yes");
		} else if (sb.toString().contains("BGIORVY")) {
			System.out.println("YES");
		} else {
			System.out.println("NO!");
		}

		br.close();
	}
}
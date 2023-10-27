package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10988_펠린드롬인지확인하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10988.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int answer = 1;
		for (int i = str.length(); i > 0; i--) {
			if (str.charAt(i - 1) != str.charAt(str.length() - i)) {
				answer = 0;
			}
		}
		System.out.println(answer);

		br.close();
	}
}
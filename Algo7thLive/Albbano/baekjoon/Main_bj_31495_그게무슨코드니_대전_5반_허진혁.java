package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*

*/
public class Main_bj_31495_그게무슨코드니_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31495.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		if (str.charAt(0) != '"' || str.charAt(str.length() - 1) != '"') {
			System.out.println("CE");
			return;
		}

		if (str.length() <= 2) {
			System.out.println("CE");
			return;
		}

		System.out.println(str.substring(1, str.length() - 1));
		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11720_숫자의합_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11720.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		n = 0;
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			n += str.charAt(i) - '0';
		}
		System.out.println(n);

		br.close();
	}
}
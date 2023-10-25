package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_27866_문자와문자열_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_27866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		System.out.println(s.charAt(n - 1));

		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11654_아스키코드_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = br.readLine().charAt(0);
		System.out.println(n);

		br.close();
	}
}
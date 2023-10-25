package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_11718_그대로출력하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_11718.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}

		br.close();
	}
}
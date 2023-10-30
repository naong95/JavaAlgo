package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30402_감마선을맞은컴퓨터_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30402.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = "";
		out: for (int i = 0; i < 15; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 15; j++) {
				str = st.nextToken();
				if (str.equals("w")) {
					str = "chunbae";
					break out;
				} else if (str.equals("b")) {
					str = "nabi";
					break out;
				} else if (str.equals("g")) {
					str = "yeongcheol";
					break out;
				}
			}
		}
		System.out.println(str);
		br.close();
	}
}
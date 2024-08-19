package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_32132_PlayStation이아니에요_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_32132.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();

		while (str.contains("PS4") || str.contains("PS5")) {
			str = str.replace("PS4", "PS");
			str = str.replace("PS5", "PS");
		}

		System.out.println(str);
		br.close();
	}
}
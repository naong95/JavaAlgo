package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30455_이제는더이상물러날곳이없다_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30455.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n % 2 == 0) {
			System.out.println("Duck");
		} else {
			System.out.println("Goose");
		}

		br.close();
	}
}
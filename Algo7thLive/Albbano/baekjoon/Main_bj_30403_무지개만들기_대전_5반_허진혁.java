package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30403_무지개만들기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int small = 0;
		int large = 0;
		br.readLine();
		String str = br.readLine();

		if (str.contains("r") && str.contains("o") && str.contains("y") && str.contains("g") && str.contains("b")
				&& str.contains("i") && str.contains("v")) {
			small = 1;
		}
		if (str.contains("R") && str.contains("O") && str.contains("Y") && str.contains("G") && str.contains("B")
				&& str.contains("I") && str.contains("V")) {
			large = 1;
		}

		if (small == 1 && large == 1) {
			System.out.println("YeS");
		} else if (small == 1) {
			System.out.println("yes");
		} else if (large == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO!");
		}

		br.close();
	}
}
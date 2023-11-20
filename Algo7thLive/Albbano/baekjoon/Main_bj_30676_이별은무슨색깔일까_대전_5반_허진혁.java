package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_30676_이별은무슨색깔일까_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_30676.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int d = Integer.parseInt(br.readLine());

		if (d >= 620) {
			System.out.println("Red");
		} else if (d >= 590) {
			System.out.println("Orange");
		} else if (d >= 570) {
			System.out.println("Yellow");
		} else if (d >= 495) {
			System.out.println("Green");
		} else if (d >= 450) {
			System.out.println("Blue");
		} else if (d >= 425) {
			System.out.println("Indigo");
		} else {
			System.out.println("Violet");
		}
		br.close();
	}
}
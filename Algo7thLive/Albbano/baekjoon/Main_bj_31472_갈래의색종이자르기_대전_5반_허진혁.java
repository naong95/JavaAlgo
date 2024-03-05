package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_31472_갈래의색종이자르기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int W = Integer.parseInt(br.readLine());

		double w = Math.sqrt(W * 2);

		System.out.println((int) (w * 4));
		br.close();
	}
}
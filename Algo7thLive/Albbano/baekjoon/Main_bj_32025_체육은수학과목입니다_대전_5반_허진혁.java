package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_32025_체육은수학과목입니다_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_32025.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int r = Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())) * 50;

		System.out.println(r);
		br.close();
	}
}
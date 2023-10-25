package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1157_단어공부_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1157.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ca = br.readLine().toUpperCase().toCharArray(); // A == 65
		int[] check = new int[26];

		for (int i = 0; i < ca.length; i++) {
			check[ca[i] - 65]++;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 26; i++) {
			max = Math.max(check[i], max);
		}
		int count = 0;
		int index = -1;
		for (int i = 0; i < 26; i++) {
			if (check[i] == max) {
				count++;
				index = i;
			}
		}
		if(count > 1) {
			System.out.println("?");
		}
		else {
			System.out.println((char) (index + 65));
		}

		br.close();
	}
}
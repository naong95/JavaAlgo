package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_28702_FizzBuzz_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_28702.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String f = br.readLine();
		String s = br.readLine();
		String t = br.readLine();

		int n = 0;
		int k = 0;

		if (isNumberic(f)) {
			n = Integer.parseInt(f);
			k = 3;
		} else if (isNumberic(s)) {
			n = Integer.parseInt(s);
			k = 2;
		} else if (isNumberic(t)) {
			n = Integer.parseInt(t);
			k = 1;
		}

		n = n + k;

		if (n % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (n % 3 == 0) {
			System.out.println("Fizz");
		} else if (n % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(n);
		}

		br.close();
	}

	public static boolean isNumberic(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
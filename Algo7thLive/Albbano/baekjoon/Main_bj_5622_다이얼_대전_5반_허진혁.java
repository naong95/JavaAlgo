package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_5622_다이얼_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_5622.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// A == 65
		char[] arr = br.readLine().toCharArray();
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 68) {
				ans += 3;
			} else if (arr[i] < 71) {
				ans += 4;
			} else if (arr[i] < 74) {
				ans += 5;
			} else if (arr[i] < 77) {
				ans += 6;
			} else if (arr[i] < 80) {
				ans += 7;
			} else if (arr[i] < 84) {
				ans += 8;
			} else if (arr[i] < 87) {
				ans += 9;
			} else {
				ans += 10;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10809_알파벳찾기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int[] ans = new int[26]; // a == 97
		for (int i = 0; i < ans.length; i++) {
			ans[i] = 100;
		}
		for (int i = 0; i < arr.length; i++) {
			if (ans[arr[i] - 97] > i) {
				ans[arr[i] - 97] = i;
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == 100) {
				ans[i] = -1;
			}
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb.toString().trim());

		br.close();
	}
}
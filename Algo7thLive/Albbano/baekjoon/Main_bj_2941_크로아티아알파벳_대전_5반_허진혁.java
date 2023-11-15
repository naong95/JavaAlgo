package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2941_크로아티아알파벳_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = 0;
		char c, nc;
		for (int i = 0; i < str.length() - 1; i++) {
			c = str.charAt(i);
			nc = str.charAt(i + 1);
			if (c == '=' || c == '-') {
				continue;
			} else if (c == 'z') {
				if (nc == '=') {
					len++;
				}
			} else if (c == 'd') {
				if (nc == 'z') {
					continue;
				} else {
					len++;
				}
			} else if (c == 'l') {
				if (nc == 'j') {
					continue;
				} else {
					len++;
				}
			} else if (c == 'n') {
				if (nc == 'j') {
					continue;
				} else {
					len++;
				}
			} else {
				len++;
			}
		}
		if (str.charAt(str.length() - 1) != '=' && str.charAt(str.length() - 1) != '-') {
			len++;
		}

		System.out.println(len);
		br.close();
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_31844_창고지기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_31844.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = -1;
		int rob = -1;
		int box = -1;
		int end = -1;

		char[] map = br.readLine().toCharArray();

		for (int i = 0; i < 10; i++) {
			if (map[i] == '@')
				rob = i;
			else if (map[i] == '#')
				box = i;
			else if (map[i] == '!')
				end = i;
		}

		if (box > rob && box < end)
			answer = end - rob - 1;
		else if (box < rob && box > end)
			answer = rob - end - 1;

		System.out.println(answer);
		br.close();
	}
}
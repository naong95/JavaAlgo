package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1620_나는야포켓몬마스터이다솜_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1620.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> nameToNo = new HashMap<>();
		Map<Integer, String> noToName = new HashMap<>();

		String s;
		for (int i = 1; i <= n; i++) {
			s = br.readLine();
			nameToNo.put(s, i);
			noToName.put(i, s);
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			if (isNumeric(s)) {
				sb.append(noToName.get(Integer.parseInt(s))).append("\n");
			} else {
				sb.append(nameToNo.get(s)).append("\n");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
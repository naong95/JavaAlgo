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

		Map<String, Integer> dogam = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			dogam.put(br.readLine(), i);
		}

		StringBuilder sb = new StringBuilder("");
		String s;
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			if (isNumeric(s)) {
				sb.append(getKey(dogam, Integer.parseInt(s))).append("\n");
			} else {
				sb.append(dogam.get(s)).append("\n");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}

	public static <K, V> K getKey(Map<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value == map.get(key)) {
				return key;
			}
		}
		return null;
	}
}
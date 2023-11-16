package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1181_단어정렬_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1181.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		String[] strArr = new String[n];
		for (int i = 0; i < n; i++) {
			strArr[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			map.put(strArr[i], strArr[i].length());
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));

		for (String key : keySet) {
			System.out.println(key);
		}

		br.close();
	}
}
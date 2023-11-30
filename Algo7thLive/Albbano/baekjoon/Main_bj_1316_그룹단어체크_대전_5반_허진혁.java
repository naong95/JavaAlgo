package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1316_그룹단어체크_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] arr;
		Set<Character> set;
		int cnt = 0;
		boolean button;
		for (int i = 0; i < n; i++) {
			button = false;
			arr = br.readLine().toCharArray();
			set = new LinkedHashSet<>();
			set.add(arr[0]);
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] == arr[j - 1]) {
					continue;
				} else {
					if (set.contains(arr[j])) {
						button = true;
						continue;
					} else {
						set.add(arr[j]);
					}
				}
			}
			if (!button) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
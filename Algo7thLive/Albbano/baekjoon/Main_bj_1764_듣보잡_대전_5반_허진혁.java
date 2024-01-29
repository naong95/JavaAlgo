package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_1764_듣보잡_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1764.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		String[] arr = new String[n];
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr);
		String str;

		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			str = br.readLine();
			if (Arrays.binarySearch(arr, str) >= 0) {
				cnt++;
				ans.add(str);
			}
		}

		Collections.sort(ans);
		sb.append(cnt);
		for (int i = 0; i < ans.size(); i++) {
			sb.append("\n").append(ans.get(i));
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
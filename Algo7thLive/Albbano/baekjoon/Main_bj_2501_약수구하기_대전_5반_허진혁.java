package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2501_약수구하기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		ArrayList<Integer> list = new ArrayList<>();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}

		if (k > list.size()) {
			System.out.println(0);
		} else {
			System.out.println(list.get(k - 1));
		}
		
		System.out.println(list);
		br.close();
	}
}
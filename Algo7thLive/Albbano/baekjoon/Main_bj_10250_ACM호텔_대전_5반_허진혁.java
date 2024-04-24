package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10250_ACM호텔_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int h = 0;
		int w = 0;
		int n = 0;

		int floor = 0;
		int roomN = 0;

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (n % h == 0) {
				floor = h;
				roomN = n / h;
			} else {
				floor = n % h;
				roomN = n / h + 1;
			}

			n = floor * 100 + roomN;
			System.out.println(n);
		}

		br.close();
	}
}
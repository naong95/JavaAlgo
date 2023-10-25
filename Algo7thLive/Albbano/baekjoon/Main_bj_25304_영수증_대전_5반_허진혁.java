package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_25304_영수증_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_25304.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int price = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			sum += price * count;
		}
		if(total == sum) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

		br.close();
	}
}
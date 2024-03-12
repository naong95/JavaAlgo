package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_10773_제로_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10773.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		Stack<Integer> s = new Stack<>();

		int n = sc.nextInt();
		int num = 0;

		for (int i = 0; i < n; i++) {
			num = sc.nextInt();
			if (num == 0) {
				s.pop();
				continue;
			}
			s.push(num);
		}
		num = 0;

		while (!s.empty()) {
			num += s.pop();
		}

		System.out.println(num);
		sc.close();
//		br.close();

	}
}
package a.a0214;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이_대전_5반_허진혁 {
	static int N, hobbit[];
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_3040.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("res/input_bj_3040.txt"));
		Scanner sc = new Scanner(System.in);
		N = 9;
		hobbit = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			hobbit[i] = sc.nextInt();
		}
		hobbitCheck(0);
		sc.close();
	}

	public static void hobbitCheck(int cnt) {// 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		if (cnt == N) {
			int hatSum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					hatSum += hobbit[i];
					count++;// 몇 명의 난쟁이가 더해지는지 체크하기 위해서
				}
			}
			if (hatSum == 100 && count == 7) {// 합이 100이고 7개가 더해졌을 때
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.println(hobbit[i]);
					}
				}
			}
			return;
		}

		isSelected[cnt] = true;
		hobbitCheck(cnt + 1);
		isSelected[cnt] = false;
		hobbitCheck(cnt + 1);

	}
}

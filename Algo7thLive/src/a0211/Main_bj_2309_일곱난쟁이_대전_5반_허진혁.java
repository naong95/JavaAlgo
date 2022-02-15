package a0211;

import java.io.*;
import java.util.*;

public class Main_bj_2309_일곱난쟁이_대전_5반_허진혁 {
	static int N, hobbit[];
	static boolean[] isSelected;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2309.txt"));
		Scanner sc = new Scanner(System.in);
		N = 9;
		hobbit = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			hobbit[i] = sc.nextInt();
		}
		Arrays.sort(hobbit);
		hobbitCheck(0);
		sc.close();
	}

	public static void hobbitCheck(int cnt) {// 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		if (cnt == N) {
			int tallSum = 0;
			int count = 0;
			int loop = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					tallSum += hobbit[i];
					count++;// 몇 명의 난쟁이가 더해지는지 체크하기 위해서
				}
			}
			if (tallSum == 100 && count == 7 && !flag) {// 합이 100이고 7개가 더해졌을 때 첫번째 조합만
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.println(hobbit[i]);
					}
				}
				flag = true;
			}
			return;
		}

		isSelected[cnt] = true;
		hobbitCheck(cnt + 1);
		isSelected[cnt] = false;
		hobbitCheck(cnt + 1);

	}
}

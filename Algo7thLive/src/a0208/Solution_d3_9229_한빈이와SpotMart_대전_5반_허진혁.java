package a0208;

import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_대전_5반_허진혁 {

	static int T, size, count, mw, max;
	static int[] weight, numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_9229.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			size = sc.nextInt();
			mw = sc.nextInt();
			numbers = new int[2];
			weight = new int[size];

			for (int i = 0; i < size; i++) {
				weight[i] = sc.nextInt();
			}

			max = 0;
			doubleSnack(0, 0);
			if (max == 0)
				System.out.println("#" + test_case + " -1");
			else
				System.out.println("#" + test_case + " " + max);

		}
		sc.close();
	}

	public static void doubleSnack(int cnt, int start) {

		if (cnt == 2) {
			if (numbers[0] + numbers[1] <= mw && max <= numbers[0] + numbers[1]) {
				max = numbers[0] + numbers[1];
			}
			return;
		}

		for (int i = start; i < size; i++) {
			numbers[cnt] = weight[i];
			doubleSnack(cnt + 1, i + 1);
		}
	}
}

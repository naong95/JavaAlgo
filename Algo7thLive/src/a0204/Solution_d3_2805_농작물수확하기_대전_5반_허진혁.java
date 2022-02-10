package a0204;

import java.io.*;
import java.util.*;

public class Solution_d3_2805_농작물수확하기_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();// 밭의 크기
			int sum = 0;// 총 수익

			for (int j = size / 2; j >= 0; j--) { // 윗 삼각형
				String s = sc.next();
				for (int k = j; k < size - j; k++) {
					sum += s.charAt(k) - '0';
				}
			}

			for (int j = 1; j <= size / 2; j++) { // 아래 삼각형
				String s = sc.next();
				for (int k = j; k < size - j; k++)
					sum += s.charAt(k) - '0';
			}

			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}

}

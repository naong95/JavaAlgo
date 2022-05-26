package a.a0214;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임_대전_5반_허진혁 {
	static int N, kyu[], in[], numbers[], win, lose;
	static boolean[] visited, isSelected;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_d3_6808.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 게임 횟수
		for (int test_case = 1; test_case <= 4; test_case++) {
			kyu = new int[10];
			in = new int[10];
			visited = new boolean[19];
			isSelected = new boolean[10];
			numbers = new int[10];
			for (int i = 1; i <= 9; i++) {
				kyu[i] = sc.nextInt();
				visited[kyu[i]] = true;
			}
			for (int i = 1; i <= 9; i++) {
				int tmp = 0;
				for (int j = 1; j <= 18; j++) {
					if (!visited[j]) {
						visited[j] = true;
						tmp = j;
						break;
					}
				}
				in[i] = tmp;
				continue;
			}
			win = 0;
			lose = 0;
			permutation(0);
			StringBuilder sb = new StringBuilder("#").append(test_case).append(" ").append(win).append(" ")
					.append(lose);
			System.out.println(sb);
		}

		sc.close();
	}

	static void permutation(int cnt) {
		if (cnt == 9) {
			int kyuSum = 0;
			int inSum = 0;
			for (int i = 1; i <= 9; i++) {
				if (kyu[i] == numbers[i - 1])
					continue;
				else if (kyu[i] > numbers[i - 1])
					kyuSum += kyu[i] + numbers[i - 1];
				else if (kyu[i] < numbers[i - 1])
					inSum += kyu[i] + numbers[i - 1];
			}
			if (kyuSum > inSum)
				win++;
			else
				lose++;

			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = in[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;

		}
	}
}

package a.a0216.tree;

import java.io.*;
import java.util.*;

public class Solution_d4_3234_준환이의양팔저울_대전_5반_허진혁 {
	/**
	 * 왼쪽 오른쪽을 자꾸 나눠서 정확히 만들려고 했던게 실수
	 * 
	 * 추의 무게의 총합은 변하지 않고 한 쪽만 순열로 선택하면 총합 - 선택한 추의 무게가 곧 반대쪽 무게이다.
	 * 
	 * Z탐색 때와 마찬가지로 구해야 하는 값에 집중하지 못 하고 너무 어려운 것을 구하려고 하다가 못 풀었다.
	 * 
	 * 항상 무엇을 구하는지 생각하자 순열로 선택된 애들의 합을 총합에서 빼면 반대쪽의 합이다
	 */
	static int res, sum;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] choo = new int[n];
			boolean[] v = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}

		}
	}
}
package baekjoon;

import java.util.*;
import java.io.*;

/*

*/
public class Main_bj_2805_나무자르기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 나무의 수
		int m = Integer.parseInt(st.nextToken()); // 필요한 최소 길이

		int[] trees = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		int max = 0;

		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		int low = 0;
		int high = max;
		int result = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int totalCutLength = getTotalCutLength(trees, mid);

			if (totalCutLength >= m) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(result);
		br.close();
	}

	private static int getTotalCutLength(int[] trees, int height) {
		int totalLength = 0;

		for (int tree : trees) {
			if (tree > height) {
				totalLength += tree - height;
			}
		}
		return totalLength;
	}
}
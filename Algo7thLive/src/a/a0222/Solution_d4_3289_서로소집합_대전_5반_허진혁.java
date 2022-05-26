package a.a0222;

import java.io.*;
import java.util.*;

public class Solution_d4_3289_서로소집합_대전_5반_허진혁 {
	/**
	 * 
	 */

	static int N;
	static int[] parents;

	public static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 총 원소 개수
			int M = sc.nextInt();// 연산 횟수
			makeSet();
			System.out.print("#" + tc + " ");
			for (int i = 0; i < M; i++) {
				int f = sc.nextInt();
				if (f == 0) {
					int a = sc.nextInt();
					int b = sc.nextInt();
					union(a, b);
				} else if (f == 1) {
					int a = sc.nextInt();
					int b = sc.nextInt();
					if (findSet(a) == findSet(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
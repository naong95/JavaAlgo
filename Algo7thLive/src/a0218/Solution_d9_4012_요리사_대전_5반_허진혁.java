package a0218;

import java.io.*;
import java.util.*;

public class Solution_d9_4012_요리사_대전_5반_허진혁 {
	/**
	 * 시너지 점수를 모두 합했을 때 A, B 요리의 점수 차의 최솟값
	 * 
	 * A에 재료의 반을 사용하고 B에 나머지
	 */
	static int used[], unused[], ingre[], synergy[][], N, A, sum, min;
	static boolean[] va, vb;

	public static void combi(int cnt, int start) {
		if (cnt == N / 2) {// 반을 뽑았다면
			ArrayList<Integer> unused = new ArrayList<>();// A에 사용하지 않은 재료(B의 재료)
			for (int i = 0; i < N; i++) {// 재료의 인덱스 담아주고
				unused.add(ingre[i]);
			}
			used = Arrays.copyOf(used, N / 2);// A는 절반만 뽑은 집합이므로 앞쪽 절반만 사용
			for (int i = 0; i < N / 2; i++) {// 사용한 재료를 걸러준다
				if (unused.contains(used[i]))
					unused.set(used[i], 0);
			}
			Collections.sort(unused);// 정렬해주고
			for (int i = 0; i < N / 2; i++) {// 0인 원소 절반이 앞쪽에 있으므로 제거
				unused.remove(0);
			}
			int a = 0;
			int b = 0;
			for (int i = 0; i < N / 2; i++) {// 2개를 뽑는 조합을 2중 for문으로 구현
				for (int j = i + 1; j < N / 2; j++) {
					int ai = used[i];
					int aj = used[j];
					int bi = unused.get(i);
					int bj = unused.get(j);
					va[i] = true;// 뽑았다면 방문처리
					vb[j] = true;
					a += synergy[ai][aj] + synergy[aj][ai];// 대각으로 시너지 점수가 있기 때문에
					b += synergy[bi][bj] + synergy[bj][bi];
					// 중간 0으로 되어 있는 대각선 기준으로 대칭인 두 원소 합하기
				}
			}
//			System.out.println("A요리재료의 시너지 합: " + a);
//			System.out.println("B요리재료의 시너지 합: " + b);

			int diff = Math.abs(a - b);// 시너지 점수 합의 차이
			min = Math.min(min, diff);// 차이가 현재 최솟값 보다 작다면 갱신

			return;
		}
		for (int i = start; i < N; i++) {
			used[cnt] = ingre[i];
			combi(cnt + 1, i + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			ingre = new int[N];
			used = new int[N];
			unused = new int[N];
			va = new boolean[N];
			vb = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
					sum += synergy[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				ingre[i] = i;
			}
			min = Integer.MAX_VALUE;
			combi(0, 0);
			System.out.println("#" + tc + " " + min);
		}
		br.close();
	}
}
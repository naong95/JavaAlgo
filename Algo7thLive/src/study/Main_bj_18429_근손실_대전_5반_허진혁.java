package study;

import java.util.*;
import java.io.*;

public class Main_bj_18429_근손실_대전_5반_허진혁 {
	static int N, K, answer;
	static int kit[];
	static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_18429.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());// 운동을 해야 하는 일수
		K = Integer.parseInt(st.nextToken());// 하루에 감소하는 중량
		kit = new int[N];// 선택된 운동키트가 들어가는 배열
		v = new boolean[N];// 키트를 사용했는지 여부 체크하는 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) kit[i] = Integer.parseInt(st.nextToken());
		
		answer = 0;
		permutation(0, 500);
		System.out.println(answer);
		br.close();
	}

	public static void permutation(int cnt, int weight) {
		if (cnt == N) {answer++; return;}
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			if (weight - K + kit[i] >= 500)/* 백트래킹 */ permutation(cnt + 1, weight - K + kit[i]);
			v[i] = false;
		}
	}
}
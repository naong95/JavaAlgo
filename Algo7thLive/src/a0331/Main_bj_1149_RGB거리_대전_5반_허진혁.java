package a0331;

import java.util.*;
import java.io.*;
/*
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고,
1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

input
집의 개수
빨 초 파 -> 칠하는 비용
*/
public class Main_bj_1149_RGB거리_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1149.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int RGB[][] = new int[N + 1][3];// 0: R, 1: G, 2: B
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) RGB[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 2; i <= N; i++) {
			RGB[i][0] += Math.min(RGB[i - 1][1],RGB[i - 1][2]);// 빨강이면 그 전 집은 초록이나 파랑
			RGB[i][1] += Math.min(RGB[i - 1][0],RGB[i - 1][2]);// 초록이면 그 전 집은 빨강이나 파랑
			RGB[i][2] += Math.min(RGB[i - 1][0],RGB[i - 1][1]);// 파랑이면 그 전 집은 빨강이나 초록
		}
		
		System.out.println(Math.min(Math.min(RGB[N][0], RGB[N][1]), RGB[N][2]));
		
		br.close();
	}
}
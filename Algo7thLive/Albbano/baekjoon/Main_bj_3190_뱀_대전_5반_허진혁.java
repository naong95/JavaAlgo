package baekjoon;

import java.util.*;
import java.io.*;

/*
격자 크기
사과 위치
회전 수 (L왼쪽 90도 D오른쪽 90도)

벽에 부딪히거나 몸에 닿으면 게임 종료
사과를 먹으면 꼬리가 하나 늘어남

좌표를 무조건 이차원 배열로 표시하려고 하지말자, i * 격자 크기 + j 라는 정수 하나로
격자 크기로 나눈 몫은 세로좌표, 나머지는 가로좌표가 된다. 좌표를 출력하는 문제가 아니라면 좋은 스킬
*/
public class Main_bj_3190_뱀_대전_5반_허진혁 {
	
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_3190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int A = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < A; i++) { // 사과 대입
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}
		
		Map<Integer, String> direction = new HashMap<>(); // 시간, 방향으로 이루어진 맵
		int D = Integer.parseInt(br.readLine());
		for (int i = 0; i < D; i++) { // 움직임 대입
			st = new StringTokenizer(br.readLine(), " ");
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direction.put(sec, dir);
		}
//		먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
//		만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
//		만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
		
		Queue<Integer> snake = new ArrayDeque<>();
		snake.offer(0);
		int second = 0;
		int i = 0;
		int j = 0;
		int d = 0;
		
		while(true) {
			int ni = i + di[d];
			int nj = j + dj[d];
			second++;
			
			if(ni < 0 || nj < 0 || ni >= N || nj >= N) break;
			if(snake.contains(ni * N + nj)) break;
			
			if(map[ni][nj] == 1) {
				map[ni][nj] = 0;
				snake.offer(ni * N + nj);
			} else {
				snake.offer(ni * N + nj);
				snake.poll();
			}
			
			if(direction.containsKey(second)) {
				if(direction.get(second).equals("D")) {
					d++;
					if(d == 4) d = 0;
				} else {
					d--;
					if(d == -1) d = 3;
				}
			}
			i = ni;
			j = nj;
		}
		
		System.out.println(second);
		br.close();
	}
}
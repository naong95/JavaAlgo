package a0216.tree;

import java.io.*;
import java.util.*;

public class Solution_5644_무선충전_대전_5반_허진혁 {
	/**
	 * 두 사용자의 배터리 충전량의 총합의 최댓값을 구해야 한다.
	 * 
	 * 무선충전이 겹치는 곳에서는 겹치는 무선충전기 중 하나를 택할 수 있고
	 * 
	 * 만약 어떤 무선충전기에 두 사용자가 같이 접속하면 반씩 충전된다.
	 * 
	 * 0: 그대로, 1: 상, 2: 우, 3: 하, 4: 좌
	 */
	static class BC {
		int X, Y, C, P;// 행, 열, 범위, 충전량

		public BC(int x, int y, int c, int p) {
			super();
			X = x;
			Y = y;
			C = c;
			P = p;
		}
	}

	public static void setBC(String[][] map, int x, int y, int c) {// 지도와 충전기 정보를 입력받아 지도에 충전기를 세팅하는 함수

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5644.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= 1; tc++) {
			int time = sc.nextInt();// 총 이동시간(1초에 한 번 이동)
			int bc = sc.nextInt();// 무선충전기의 개수
			String map[][] = new String[11][11];// 지도
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					map[i][j] = "";// 빈 공간으로 초기화(널 방지)
				}
			}
			int[] userA = new int[time];
			int[] userB = new int[time];
			for (int i = 0; i < time; i++) {// A의 이동정보
				userA[i] = sc.nextInt();
			}
			for (int i = 0; i < time; i++) {// B의 이동정보
				userB[i] = sc.nextInt();
			}
			BC[] chargers = new BC[bc];// 충전기 클래스를 담는 배열
			for (int i = 0; i < bc; i++) {// 정보 입력받아서 클래스 생성
				chargers[i] = new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

		}
		sc.close();
	}
}
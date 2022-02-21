package a0218;

import java.io.*;
import java.util.*;

public class Main_bj_10158_개미_대전_5반_허진혁_시간초과 {
	/**
	 * 얼핏 보면 2차원 배열에서 dfs를 돌려야 할 것 같다.
	 * 
	 * 개미를 가로, 세로 좌표를 가지고 있는 정수 배열로 만들어서 쓰자
	 */
	static int dx = 1, dy = 1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10158.txt"));
		Scanner sc = new Scanner(System.in);
		int[] ant = new int[2];
		int garo = sc.nextInt();// 개미 이동 가로 최대 길이
		int sero = sc.nextInt();// 개미 이동 세로 최대 길이

		ant[0] = sc.nextInt();// 개미의 시작 x좌표
		ant[1] = sc.nextInt();// 개미의 시작 y좌표
		int after = sc.nextInt();// 만큼의 시간이 지나고 개미의 좌표는 ?
		System.out.println("시작 위치: " + ant[0] + " " + ant[1]);
		for (int i = 0; i < after; i++) {
			if ((ant[0] + dx > garo || ant[0] + dx < 0) && (0 <= ant[1] + dy && ant[1] + dy <= sero)) {
				// 가로만 범위를 벗어나는 경우
				dx *= -1;
			} else if ((0 <= ant[0] + dx && ant[0] + dx <= garo) && (ant[1] + dy > sero || ant[1] + dy < 0)) {
				// 세로만 범위를 벗어나는 경우
				dy *= -1;
			} else if (0 <= ant[0] + dx && ant[0] + dx <= garo && 0 <= ant[1] + dy && ant[1] + dy <= sero) {
				// 범위를 벗어나지 않는 경우
				dx *= 1;
				dy *= 1;
			} else if ((ant[0] + dx > garo || ant[0] + dx < 0) && (ant[1] + dy > sero || ant[1] + dy < 0)) {
				// 가로, 세로 모두 범위를 벗어나는 경우(꼭지점)
				dx *= -1;
				dy *= -1;
			}
			ant[0] += dx;
			ant[1] += dy;
			System.out.println(ant[0] + " " + ant[1]);
		}
//		System.out.println(ant[0] + " " + ant[1]);
		System.out.println(after + "시간 후 개미의 위치는: " + "(" + ant[0] + ", " + ant[1] + ")");
		sc.close();
	}
}
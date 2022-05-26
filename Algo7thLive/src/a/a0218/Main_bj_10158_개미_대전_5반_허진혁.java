package a.a0218;

import java.io.*;
import java.util.*;

public class Main_bj_10158_개미_대전_5반_허진혁 {
	/**
	 * 최종 좌표만 구하면 된다
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10158.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int garo = Integer.parseInt(st.nextToken());// 개미 이동 가로 최대 길이
		int sero = Integer.parseInt(st.nextToken());// 개미 이동 세로 최대 길이

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());// 개미의 시작 x좌표
		int q = Integer.parseInt(st.nextToken());// 개미의 시작 y좌표

		int after = Integer.parseInt(br.readLine());// 만큼의 시간이 지나고 개미의 좌표는 ?
		int x = (p + after) % (2 * garo);
		int y = (q + after) % (2 * sero);

		x = garo - Math.abs(garo - x);
		y = sero - Math.abs(sero - y);

		sb.append(x).append(" ").append(y);
		System.out.println(sb.toString());
		br.close();
	}
}
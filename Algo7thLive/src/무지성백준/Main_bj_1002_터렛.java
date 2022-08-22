package 무지성백준;

import java.util.*;
import java.io.*;

/*
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 
10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 
만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
*/
public class Main_bj_1002_터렛 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("muji/input_bj_1002.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = -2;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int rd = (int) Math.pow(r1 - r2, 2);// 반지름의 차이
			int rp = (int) Math.pow(r1 + r2, 2);// 반지름의 합
			int x = x2 - x1;
			int y = y2 - y1;
			int r = (int) (Math.pow(x, 2) + Math.pow(y, 2));// 두 터렛 사이의 거리의 제곱 

			if(x1 == x2 && y1 == y2 && r1 == r2) result = -1;
			else if(r > rp || r < rd) result = 0;
			else if(r == rp || r == rd) result = 1;
			else result = 2;
			System.out.println(result);
		}
		br.close();
	}
}
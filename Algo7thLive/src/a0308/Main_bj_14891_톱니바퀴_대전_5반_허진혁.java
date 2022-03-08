package a0308;

import java.util.*;
import java.io.*;

/*
N극은 0, S극은 1로 나타나있다.
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다.
방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
1234 톱니바퀴가 순서대로 S극이라면 1248 점을 획득한다.
2626: index

회전이 끝난 후 몇 점을 획득했는지 출력하자
*/
public class Main_bj_14891_톱니바퀴_대전_5반_허진혁 {
	static int wheels[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14891.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < 8; j++) {
				wheels[i][j] = str[j].charAt(0) - '0';
			}
		}
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotation(num, dir);
		}
		for (int[] ia : wheels) {
			System.out.println(Arrays.toString(ia));
		}
		
		br.close();
	}

	static void rotation(int num, int dir) {
		int part11 = wheels[0][2];
		int part12 = wheels[1][6];

		int part21 = wheels[1][2];
		int part22 = wheels[2][6];

		int part31 = wheels[2][2];
		int part32 = wheels[3][6];
		boolean[] flag = new boolean[3];
		if (part11 != part12)
			flag[0] = true;
		if (part21 != part22)
			flag[1] = true;
		if (part31 != part32)
			flag[2] = true;

		if (num == 1) {
			if (dir == 1) {
				clock(wheels[0]);
				if(flag[0]) counter(wheels[1]);
				if(flag[1]) clock(wheels[2]);
				if(flag[2]) counter(wheels[3]);
			} else {
				counter(wheels[0]);
				if(flag[0]) clock(wheels[1]);
				if(flag[1]) counter(wheels[2]);
				if(flag[2]) clock(wheels[3]);
			}
		}
		if (num == 2) {
			if (dir == -1) {
				counter(wheels[1]);
				if(flag[0]) clock(wheels[0]);
				if(flag[1]) clock(wheels[2]);
				if(flag[2]) counter(wheels[3]);
			} else {
				clock(wheels[1]);
				if(flag[0]) counter(wheels[0]);
				if(flag[1]) counter(wheels[2]);
				if(flag[2]) clock(wheels[3]);
			}
		}
		if (num == 3) {
			if (dir == 1) {
				clock(wheels[2]);
				if(flag[1]) counter(wheels[1]);
				if(flag[2]) counter(wheels[3]);
				if(flag[0]) clock(wheels[0]);
			} else {
				counter(wheels[2]);
				if(flag[1]) clock(wheels[1]);
				if(flag[2]) clock(wheels[3]);
				if(flag[0]) counter(wheels[0]);
			}
		}
		if (num == 4) {
			if (dir == -1) {
				counter(wheels[3]);
				if(flag[2]) clock(wheels[2]);
				if(flag[1]) counter(wheels[1]);
				if(flag[0]) clock(wheels[0]);
			} else {
				clock(wheels[3]);
				if(flag[2]) counter(wheels[2]);
				if(flag[1]) clock(wheels[1]);
				if(flag[0]) counter(wheels[0]);
			}
		}
	}

	static void clock(int[] a) {
		int tmp = a[7];
		for (int i = 6; i >= 0; i--) {
			a[i + 1] = a[i];
		}
		a[0] = tmp;
	}

	static void counter(int[] a) {
		int tmp = a[0];
		for (int i = 1; i < 8; i++) {
			a[i - 1] = a[i];
		}
		a[7] = tmp;
	}
}

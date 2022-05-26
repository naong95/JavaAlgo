package a.a0413;

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
public class Solution_d9_4013_특이한자석_대전_5반_허진혁 {
	static int wheels[][];// 회전이 계속 갱신될 수 있도록 스태틱

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			wheels = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					wheels[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rotation(num, dir);
			}
			int ans = wheels[0][0] + wheels[1][0] * 2 + wheels[2][0] * 4 + wheels[3][0] * 8;
			System.out.println("#" + tc + " " + ans);// 답 출력
		}

		br.close();
	}

	static void rotation(int num, int dir) {
		// 톱니가 만나는 곳의 극의 동일 여부를 체크하면 된다
		// 4개의 톱니이므로 3군데서 만난다
		// 처음
		int part11 = wheels[0][2];
		int part12 = wheels[1][6];
		// 두번째
		int part21 = wheels[1][2];
		int part22 = wheels[2][6];
		// 마지막
		int part31 = wheels[2][2];
		int part32 = wheels[3][6];
		boolean[] flag = new boolean[3];// 극이 다르면 그쪽도 회전이 일어나므로 체크해서 저장
		if (part11 != part12)
			flag[0] = true;
		if (part21 != part22)
			flag[1] = true;
		if (part31 != part32)
			flag[2] = true;
		// 회전이 동시에 일어나야 하므로 저장 해놓고 저장 해놨던 상태를 보고 회전을 결정한다
		// 1, 4번 톱니가 회전하는 경우는 순차적으로 극이 다른걸 체크해서 다음 회전을 할지 안 할지 결정
		// 2, 3번 톱니는 회전하는 톱니 양쪽 톱니를 살피고 제일 바깥쪽 톱니와 만나는 톱니의 회전을 결정

		if (num == 1) {
			if (dir == 1) {
				clock(wheels[0]);
				if (flag[0]) {
					counter(wheels[1]);
					if (flag[1]) {
						clock(wheels[2]);
						if (flag[2])
							counter(wheels[3]);
					}
				}
			} else {
				counter(wheels[0]);
				if (flag[0]) {
					clock(wheels[1]);
					if (flag[1]) {
						counter(wheels[2]);
						if (flag[2])
							clock(wheels[3]);
					}
				}
			}
		}
		if (num == 2) {
			if (dir == -1) {
				counter(wheels[1]);
				if (flag[0])
					clock(wheels[0]);
				if (flag[1]) {
					clock(wheels[2]);
					if (flag[2])
						counter(wheels[3]);
				}
			} else {
				clock(wheels[1]);
				if (flag[0])
					counter(wheels[0]);
				if (flag[1]) {
					counter(wheels[2]);
					if (flag[2])
						clock(wheels[3]);
				}
			}
		}
		if (num == 3) {
			if (dir == 1) {
				clock(wheels[2]);
				if (flag[2])
					counter(wheels[3]);
				if (flag[1]) {
					counter(wheels[1]);
					if (flag[0])
						clock(wheels[0]);
				}
			} else {
				counter(wheels[2]);
				if (flag[2])
					clock(wheels[3]);
				if (flag[1]) {
					clock(wheels[1]);
					if (flag[0])
						counter(wheels[0]);
				}
			}
		}
		if (num == 4) {
			if (dir == -1) {
				counter(wheels[3]);
				if (flag[2]) {
					clock(wheels[2]);
					if (flag[1]) {
						counter(wheels[1]);
						if (flag[0])
							clock(wheels[0]);
					}
				}
			} else {
				clock(wheels[3]);
				if (flag[2]) {
					counter(wheels[2]);
					if (flag[1]) {
						clock(wheels[1]);
						if (flag[0])
							counter(wheels[0]);
					}
				}
			}
		}
	}

	static void clock(int[] a) {// 시계
		int tmp = a[7];
		for (int i = 6; i >= 0; i--) {
			a[i + 1] = a[i];
		}
		a[0] = tmp;
	}

	static void counter(int[] a) {// 반시계
		int tmp = a[0];
		for (int i = 1; i < 8; i++) {
			a[i - 1] = a[i];
		}
		a[7] = tmp;
	}
}

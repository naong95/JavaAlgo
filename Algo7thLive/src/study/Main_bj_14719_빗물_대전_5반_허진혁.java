package study;

import java.util.*;
import java.io.*;

/*
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)
두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.
따라서 블록 내부의 빈 공간이 생길 수 없다.
또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.
*/

public class Main_bj_14719_빗물_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		int ans = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < W; j++) {
			int h = Integer.parseInt(st.nextToken());
			for(int i = 0; i < h; i++) map[i][j] = 1;
		}
		for (int[] is : map) System.out.println(Arrays.toString(is));
		for (int i = 0; i < H; i++) {
			ans += rain(map[i]);
		}
		System.out.println(ans);
		br.close();
	}
	private static int rain(int[] line) {
		int cnt = 0;
		int len = line.length;
		for(int i = 0; i < len; i++) {
			if(line[i] == 1) {
				int j = i;
				int check = 0;
				while(j < len - 1) {
					if(line[j + 1] == 0) check++;
					if(line[j + 1] == 1) {
						cnt += check;
						break;
					}
					j++;
				}
			}else if(line[i] == 0) continue;
		}
		return cnt;
	}
}
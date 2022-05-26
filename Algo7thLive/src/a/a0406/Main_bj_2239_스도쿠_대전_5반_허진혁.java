package a.a0406;

import java.util.*;

import javax.sound.midi.Soundbank;

import java.io.*;

public class Main_bj_2239_스도쿠_대전_5반_허진혁 {
	/*
	 * 맵의 크기가 정해져있다 안 채워진 칸을 리스트에 담고 반복문 돌 때 조건 체크해서
	 */

	static int[][] board;
	static List<int[]> list;
	static boolean end;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2239.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];// 9X9로 정해져있다
		list = new LinkedList<int[]>();

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = str.charAt(j) - '0';
				if (board[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		end = false;
		fill(0);
	}

	private static void fill(int now) {
		if(end) return;
		if (list.size() == now) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			end = true;
			return;
		}
		int r = list.get(now)[0];// i뽑아서 고정 -> 가로체크
		int c = list.get(now)[1];// j뽑아서 고정 -> 세로체크

		boolean[] check = new boolean[10];// 1부터 9까지 써야하므로

		for (int j = 0; j < 9; j++) {// 가로
			if (board[r][j] != 0)
				check[board[r][j]] = true;
		}
		for (int i = 0; i < 9; i++) {// 세로
			if (board[i][c] != 0)
				check[board[i][c]] = true;
		}
		int miniI = (r / 3) * 3;
		int miniJ = (c / 3) * 3;
		for (int i = miniI; i < miniI + 3; i++) {// 3X3 미니네모
			for (int j = miniJ; j < miniJ + 3; j++) {
				if (board[i][j] != 0)
					check[board[i][j]] = true;
			}
		}
		for (int i = 1; i < 10; i++) {
			if (!check[i]) {
				board[c][r] = i;
				fill(now + 1);
				board[c][r] = 0;
			}
		}
	}
}
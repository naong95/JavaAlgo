package a0311;

import java.util.*;
import java.io.*;

/*
덧셈 뺄셈 곱셈 나눗셈
나눗셈은 정수 몫만 취한다
*/
public class Main_bj_14888_연산자끼워넣기_대전_5반_허진혁 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] number;
	static int[] oper = new int[4];// + - * /

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14888.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}

		combi(number[0], 1);
		System.out.println(max);
		System.out.println(min);

		sc.close();
	}

	static void combi(int result, int cnt) {
		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}
		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				oper[i]--;// 연산에 사용하면 하나 없어져야하므로
				switch(i) {
				case 0: combi(result + number[cnt], cnt + 1); break;
				case 1: combi(result - number[cnt], cnt + 1); break;
				case 2: combi(result * number[cnt], cnt + 1); break;
				case 3: combi(result / number[cnt], cnt + 1); break;
				}
				oper[i]++;// 재귀 끝나고 다시 복구
			}
		}
	}
}
package a.a0215.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_2839_설탕배달_대전_5반_허진혁 {

	/**
	 * 설탕은 3kg, 5kg 짜리
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_bj_2839.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 배달해야 하는 총 설탕무게
		if ((N % 5) == 0) {// 5의 배수라면 몫이 최소 개수
			System.out.println(N / 5);
		}
		if ((N % 5) != 0) {// 5의 배수가 아니라면
			int mod = N % 5;// 5로 나눴을 때 나머지
			if (mod % 3 == 0) {// 가 3의 배수라면 5로 나눈 몫 + 나머지의 3으로 나눈 몫
				System.out.println((N / 5) + (mod / 3));
			} else {// 5로 나눈 나머지가 3의 배수가 아니라면
				int min = Integer.MAX_VALUE;
				if (N == 4 || N == 7)// 반례 2가지 1자리 수이면서 나머지가 4, 7인 경우
					min = -1;
				for (int i = 1; i <= N / 3; i++) {// 3을 하나씩 증가시키면서 빼고 그 값이 5로 나누어 떨어지면 뺀 3의 개수 + 5로 나눈 몫
					if ((N - 3 * i) % 5 == 0) {
						min = Math.min(min, i + ((N - 3 * i) / 5));// 을 최솟값 갱신 후
					}
				}
				// 출력
				System.out.println(min);
			}
		}
		br.close();
	}
}
package a0215.greedy;

import java.io.*;
import java.util.*;

public class Main_jo_1828_냉장고_대전_5반_허진혁 {

	/**
	 * 오늘 배웠던 회의실 시작시간 끝시간을 알 때 가장 많은 회의를 잡는 아이디어로 접근하면 겹칠 때 카운트 해서 카운트 최솟값
	 */

	static class chemical implements Comparable<chemical> {
		int min, max;

		public chemical(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(chemical o) {
			return this.max != o.max ? this.max - o.max : this.min - o.min;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_jo_1828.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 화학물질 개수
		chemical[] chemicals = new chemical[N];// 화학물질 클래스로 이루어진 N개의 배열
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			chemicals[i] = new chemical(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}

		System.out.println(counter(chemicals));

		br.close();
	}

	public static int counter(chemical[] chemicals) {
		int count = 0;
		Arrays.sort(chemicals);
		int size = chemicals.length;
		for (int i = 1; i < size; i++) {
			if (chemicals[i - 1].max < chemicals[i].min) {
				count++;
			}
		}
		if (count == 0) {
			if (size % 3 == 0)
				return size / 3;
			else if (size % 3 != 0)
				return size / 3 + 1;
		}

		return size / 3 + count;

	}
}
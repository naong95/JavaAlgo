package a0208;

import java.io.*;
import java.util.*;

public class Solution_d3_1228_암호문1_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1228.txt"));
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			LinkedList<Integer> list = new LinkedList<>();
			int len = sc.nextInt();
			for (int i = 0; i < len; i++) {
				list.add(i, sc.nextInt());
			}
			int iter = sc.nextInt();
			int idx = -1;
			int inputs = 0;
			String del = "";
			for (int i = 0; i < iter; i++) {
				del = sc.next();// 하나 삭제
				idx = sc.nextInt();// 넣어야 할 자리
				inputs = sc.nextInt();// 들어갈 개수
				for (int j = idx; j < idx + inputs; j++) {
					list.add(j, sc.nextInt());// 알아서 밀어주기 때문에 받아 와서 중간 삽입
				}
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}

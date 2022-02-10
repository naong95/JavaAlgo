package a0207;

import java.io.*;
import java.util.*;

public class Solution_d4_1218_괄호짝짓기_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			String[] covers = sc.next().split("");

			Stack<String> cover = new Stack<>();

			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;

			for (int i = 0; i < T; i++) {
				if (covers[i].equals("(")) {
					cover.push(covers[i]);
					count1++;
				} else if (covers[i].equals("[")) {
					cover.push(covers[i]);
					count2++;
				} else if (covers[i].equals("{")) {
					cover.push(covers[i]);
					count3++;
				} else if (covers[i].equals("<")) {
					cover.push(covers[i]);
					count4++;
				} else
					cover.push(covers[i]);
			}
			for (int i = 0; i < T; i++) {
				if (cover.peek().equals(")")) {
					cover.pop();
					count1--;
				} else if (cover.peek().equals("]")) {
					cover.pop();
					count2--;
				} else if (cover.peek().equals("}")) {
					cover.pop();
					count3--;
				} else if (cover.peek().equals(">")) {
					cover.pop();
					count4--;
				} else
					cover.pop();
			}

			if (count1 == 0 && count2 == 0 && count3 == 0 && count4 == 0) {
				System.out.println("#" + test_case + " 1");
			} else
				System.out.println("#" + test_case + " 0");

		}
		sc.close();
	}
}

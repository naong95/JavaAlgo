package a0210.treebfsdfs;

import java.io.*;
import java.util.*;

public class Solution_d4_1233_사칙연산유효성검사_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_d4_1233.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());// 연산 줄 수
			LinkedList<Object[]> tree = new LinkedList<>();
			for (int i = 0; i <= N; i++) {// 빈 링크드리스트 만들기 위해서 대입
				tree.offer(new Object[] { 0, 0 });
			}

			for (int i = 1; i <= N; i++) {// 띄어쓰기로 구분 되어 있는 노드번호, 값, 왼쪽자식, 오른쪽자식
				String[] s = br.readLine().split(" ");// 인덱스 0, 1, 2, 3으로 대입될 수 있게
				tree.add(i, s);// 자식이 없는 노드의 배열 길이는 2일 것이다.
			}

			int vaild = -1;
			for (int i = 0; i <= N; i++) {
				if (tree.get(i).length == 2) {// 배열 길이가 2라서 자식이 없을 때
					if (tree.get(i)[1].equals("+"))
						vaild = 0;
					else if (tree.get(i)[1].equals("-"))
						vaild = 0;
					else if (tree.get(i)[1].equals("*"))
						vaild = 0;
					else if (tree.get(i)[1].equals("/"))
						vaild = 0;// 그 노드의 값이 사칙연산 문자 중 하나라면 vaild를 0으로
				} else
					vaild = 1;// 아닌 경우 연산 가능
			}
			System.out.println("#" + test_case + " " + vaild);

		}
		br.close();
	}
}

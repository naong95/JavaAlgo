package a.a0203.iorecursive;

import java.io.*;
import java.util.*;

public class Main_bj_17478_재귀함수가뭔가요_대전_5반_허진혁 {

	static int count = 0;
	static String str = "";
	static String str2 = "";

	public static void ans(int n) {
		if (n == 0) {
			System.out.println(str + "\"재귀함수가 뭔가요?\"\r\n" + str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\r\n" + str + "라고 답변하였지.");
			return;
		}

		// 기저
		System.out.println(str + "\"재귀함수가 뭔가요?\"\r\n" + str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n"
				+ str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n" + str
				+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		str = str + "____";
		ans(n - 1);
		System.out.println(str + "라고 답변하였지.");
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17478.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		ans(n);
		sc.close();
	}
}
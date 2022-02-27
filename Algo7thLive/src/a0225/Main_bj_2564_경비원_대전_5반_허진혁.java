package a0225;

import java.io.*;
import java.util.*;

public class Main_bj_2564_경비원_대전_5반_허진혁 {
	/*
	 * 1 2 3 4 북남서동
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2564.txt"));
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();// 가로
		int s = sc.nextInt();// 세로
		int sum = (g + s) * 2;// 직사각형 전체 길이
		int N = sc.nextInt();// 상점의 개수
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < N + 1; i++) {// 동근이의 위치까지
			int nswe = sc.nextInt();
			int location = sc.nextInt();
			
			if(nswe == 1) {// 북
				list.add(location);
			}else if(nswe == 2) {// 남
				list.add(g + s + (g - location));
			}else if(nswe == 3) {// 서
				list.add(2 * g + s + (s - location));
			}else{// 동
				list.add(g + location);
			}
		}
		int len = list.get(list.size() - 1);// 동근이의 위치
		int total = 0;
		for(int i = 0; i < N; i++) {
			int tmp = Math.abs(list.get(i) - len);
			total += Math.min(tmp, sum - tmp);
		}
		System.out.println(total);
		sc.close();
	}
}
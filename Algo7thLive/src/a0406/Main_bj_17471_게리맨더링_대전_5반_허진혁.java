package a0406;

import java.io.*;
import java.util.*;
/*
	첫째 줄에 구역의 개수 N이 주어진다. 
	둘째 줄에 구역의 인구가 1번 구역부터 N번 구역까지 순서대로 주어진다. 
	인구는 공백으로 구분되어져 있다.
	셋째 줄부터 N개의 줄에 각 구역과 인접한 구역의 정보가 주어진다. 
	각 정보의 첫 번째 정수는 그 구역과 인접한 구역의 수이고, 이후 인접한 구역의 번호가 주어진다. 
	모든 값은 정수로 구분되어져 있다.
	구역 A가 구역 B와 인접하면 구역 B도 구역 A와 인접하다.
	인접한 구역이 없을 수도 있다.
	
	클래스로 만들 필요가 없다
	완탐만 생각해서 문제를 처음부터 잘못 생각
	입력 받아서 인접행렬 만들기
	
	둘로 나눠도 가능한 조합인지 어떻게 판단 ?
	-> 부분집합으로 뽑고
	-> 두쪽 중 한 부분이 모두 방문 가능하면 잘 나눠진 경우다
	-> 그 때만 최솟값 갱신
	
 */

public class Main_bj_17471_게리맨더링_대전_5반_허진혁 {
	
	static class area{
		int pp;
		List<Integer> link;
		
		public area(int pp) {
			super();
			this.pp = pp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 구역의 개수
		area[] aa = new area[N + 1];
//		aa[0] = new area(0);
//		aa[0].link = new LinkedList<>(); // null 방지
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			aa[i] = new area(Integer.parseInt(st.nextToken()));
			aa[i].link = new LinkedList<>();
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				aa[i].link.add(Integer.parseInt(st.nextToken()));
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			Queue<area> q = new ArrayDeque<>();
			area cur = aa[i];
			
			
		}
	}
}
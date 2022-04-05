package a0405;

import java.util.*;
import java.io.*;

public class Main_bj_15961_회전초밥_대전_5반_허진혁 {
	/*
	초밥을 어디에 저장하면 좋을까
	처음으로 떠오른 것은 배열
	
	시작 초밥부터 k칸 만큼 중복 검사(쿠폰 번호도 동시에 검사)
	
	초밥 담을 배열 하나 
	중복체크를 자동으로 해주는 set을 하나 만들고 key는 초밥의 가짓수, value는 쿠폰 사용 가능 여부
	
	회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때
	손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 프로그램을 작성하시오.
	
	회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
	
	-----> 시간 초과;;
	*/
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());// 접시의 수
		int d = Integer.parseInt(st.nextToken());// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());// 쿠폰 번호
		
		int[] sushi = new int[N + k - 1];// 벨트 위의 초밥을 담을 배열
		for(int i = 0; i < N + k - 1; i++) {
			if(i >= N) sushi[i] = sushi[i - N];
			else sushi[i] = Integer.parseInt(br.readLine());
		}
		HashSet<Integer> check = new HashSet<>();
		Queue<int[]> kinds = new ArrayDeque<int[]>();
		for(int i = 0; i < N; i++) {
			int coupon = 1;
			for(int j = i; j < i + k; j++) {
				if(sushi[j] == c) {
					check.add(sushi[j]);
					coupon = 0;
				}
				else check.add(sushi[j]);
			}
			kinds.offer(new int[] {check.size(), coupon});
			check.clear();
		}
		
		int max = 0;
		while(!kinds.isEmpty()) {
			int[] cur = kinds.poll();
			if(cur[1] == 0) {
				max = Math.max(max, cur[0]);
			}else if(cur[1] == 1) {
				max = Math.max(max, cur[0] + 1);
			}
		}
		System.out.println(max);
		br.close();
	}
}
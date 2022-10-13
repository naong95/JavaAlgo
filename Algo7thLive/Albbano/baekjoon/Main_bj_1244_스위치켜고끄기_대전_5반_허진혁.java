package baekjoon;
import java.util.*;
import java.io.*;
/*
스위치 개수
스위치 상태
학생 수
남자 1, 여자 2
받은 번호

남자는 받은 번호의 배수 스위치들 상태 변경
여자는 받은 번호로부터 양쪽으로 대칭일때 동안 스위치들 상태 변경
*/
public class Main_bj_1244_스위치켜고끄기_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] swit = new int[N + 1];
		swit[0] = 2;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N ; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			int add = number;
			
			if(gender == 1) {
				while(number <= N) {
					if(swit[number] == 0) swit[number] = 1;
					else swit[number] = 0;
					number += add;
				}
			} else {
				if(swit[number] == 0) swit[number] = 1;
				else swit[number] = 0;
				int left = number - 1;
				int right = number + 1;
				if(left < 1 || right > N) continue;
				while(swit[left] == swit[right]) {
					if(swit[left] == 0) {
						swit[left] = 1;
						swit[right] = 1;
					} else {
						swit[left] = 0;
						swit[right] = 0;
					}
					left--;
					right++;
					if(left < 1 || right > N) break;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(swit[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
		br.close();
	}
}
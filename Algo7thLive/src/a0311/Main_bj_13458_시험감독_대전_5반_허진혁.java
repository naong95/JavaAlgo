package a0311;

/*
시험장의 개수
각 시험장의 응시자 수
총감독이 감시할 수 있는 명수, 부감독이 감시할 수 있는 명수

총감독은 무조건 1명
*/
import java.util.*;
import java.io.*;

public class Main_bj_13458_시험감독_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_13458.txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 시험장의 개수
		int[] room = new int[N];
		
		for(int i = 0; i < N; i++) room[i] = sc.nextInt();
		
		int B = sc.nextInt();// 총감독 감시 가능 수
		int C = sc.nextInt();// 부감독 감시 가능 수
		long count = 0;
		for(int i = 0; i < N; i++) {
			if(room[i] <= B) {count++; continue;}
			// 총감독 감시 가능 수 보다 작다면 +1만 해주고 다음 시험장으로
			else {// 총감독 감시 가능 수 보다 크다면 +1 해주고
				count++;
				room[i] -= B;// 각 시험장 인원에서 총감독이 맡아주는 사람 수를 뺀다
				if(room[i] % C == 0) count+= (room[i] / C);
				else if(room[i] % C != 0) count+= (room[i] / C) + 1;
				// 총감독의 인원을 제외하고 나머지 인원은 부감독이 맡을 수 있는 인원으로
				// 나눴을 때 딱 떨어지면 몫만큼 부감독 배치, 나머지가 발생하면 부감독 1명 더 배치
			}
		}
		System.out.println(count);
		sc.close();
	}
}
package a.a0401;

import java.util.*;
import java.io.*;

public class Main_bj_1194_달이차오른다가자_대전_5반_허진혁 {
	/*
	민식이는 지금 미로 속에 있다. 미로는 직사각형 모양이고, 
	여행길을 떠나기 위해 미로를 탈출하려고 한다. 
	미로는 다음과 같이 구성되어져있다.

	빈 칸: 언제나 이동할 수 있다. ('.')
	벽: 절대 이동할 수 없다. ('#')
	열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
	문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
	민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
	출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
	
	달이 차오르는 기회를 놓치지 않기 위해서, 미로를 탈출하려고 한다. 
	한 번의 움직임은 현재 위치에서 수평이나 수직으로 한 칸 이동하는 것이다.
	
	민식이가 미로를 탈출하는데 걸리는 이동 횟수의 최솟값을 구하는 프로그램을 작성하시오.
	*/
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] miro = new char[N][M];
		for(int i = 0; i < N; i++) {
			miro[i] = br.readLine().toCharArray();
		}
		
		
		br.close();
	}
}
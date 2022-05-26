package a.a0408;

import java.io.*;
import java.util.*;
/*
행으로 체크, 열로 체크
대각선 활주로는 없으므로 1차원 배열을 검사하는 식으로

활주로의 높이는 항상 1 --> 높낮이 차가 1인 곳에만 설치 가능

활주로를 설치했을 때 길이가 범위 밖으로 넘어가는지

이미 활주로가 설치되어 있는지

활주로가 설치되는 동안 같은 높이인지
*/
public class Solution_d9_4014_활주로건설_대전_5반_허진혁2 {
	
	static int N, X, map[][], rap[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 지도 크기
			X = Integer.parseInt(st.nextToken());// 활주로 길이
			
			map = new int[N + 1][N + 1];
			rap = new int[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) rap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
			}
			/////////////////////////////////////////////////////////////////////////////
			
			int count = 0;
			int[] arr = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				if(check(map[i])) count++; 						// 행 1줄 체크
				
//				for(int j = 1; j <= N; j++) arr[j] = map[j][i]; // 열 1줄 받아와서
//				if(check(arr)) count++; 						// 열 1줄 체크
				
				if(check(rap[i])) count++; 						// 열 1줄 체크 simple is best
			}
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
	
	static boolean check(int[] arr) {
		boolean[] v = new boolean[N + 1];						// 활주로가 설치되었는지 여부

		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i + 1]) continue;					// 다음 칸과 높이가 같다면 패스
			
			//내리막
			else if(arr[i] - 1 == arr[i + 1]) {   				// 현재 칸의 높이가 다음 칸보다 1 크다면 내리막 활주로 준비
				for(int j = i + 1; j < i + 1 + X; j++) {		// 다음 칸부터 길이 X만큼 체크
					if(j > N) return false;						// 배열 범위를 벗어났다면 패스
					if(v[j]) return false;						// 활주로가 설치되어 있다면 패스
					if(arr[i + 1] != arr[j]) return false;		// 활주로가 설치되는 곳이 높이가 같지 않다면 패스
					v[j] = true;								// 활주로를 설치할 수 있다면 방문처리
				}
			}
			//오르막
			else if(arr[i] + 1 == arr[i + 1]) {					// 현재 칸의 높이가 다음 칸보다 1 작다면 오르막 활주로 준비
				for(int j = i; j > i - X; j--) {				// 현재 칸부터 길이 X만큼 거꾸로 체크
					if(j < 1) return false;						// 범위 아웃
					if(v[j]) return false;						// 이미 설치
					if(arr[i] != arr[j]) return false;			// 현재 칸부터 활주로 설치기 때문에 높이 같은지 비교
					v[j] = true;								// 설치 되면 방문처리
				}
			}
			else return false;
		}
		return true;
	}
}
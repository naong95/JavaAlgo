package a.a0311;

/*
행으로 한 번, 열로 한 번 체크 한다
대각선 경사로는 없으므로 1차원 배열을 검사하는 식으로

경사로의 길이는 경사로가 시작되는 곳의 높이기 때문에
경사로를 설치했을 때 길이가 넘어가는지
이미 경사로가 있는지
경사로가 설치되는 동안 같은 높이인지
*/
import java.util.*;
import java.io.*;

public class Main_bj_14890_경사로_대전_5반_허진혁 {

	static int N, L, map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14890.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j<= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			if(check(i, 0, 0)) count++;// 열 1줄 체크
			if(check(0, i, 1)) count++;// 행 1줄 체크
		}
		System.out.println(count);
		sc.close();
	}
	
	static boolean check(int r, int c, int flag) {
		int[] height = new int[N + 1];							// 길의 높이를 저장할 1차원 배열
		boolean[] v = new boolean[N + 1];						// 경사로가 설치되었는지 여부
		
		for(int i = 1; i <= N; i++) {
			if(flag == 0) height[i] = map[r][i];				// 열 1줄
			if(flag == 1) height[i] = map[i][c];				// 행 1줄
		}
		for(int i = 1; i < N; i++) {
			if(height[i] == height[i + 1]) continue;			// 다음 칸과 높이가 같다면 패스
			else if(height[i] - 1 == height[i + 1]) {   		// 현재 칸의 높이가 다음 칸보다 1 크다면 내리막 경사로 준비
				for(int j = i + 1; j < i + 1 + L; j++) {		// 다음 칸부터 높이 L만큼 체크
					if(j > N) return false;						// 배열 범위를 벗어났다면 패스
					if(v[j]) return false;						// 경사로가 설치되어 있다면 패스
					if(height[i + 1] != height[j]) return false;// 경사로가 설치되는 곳이 높이가 같지 않다면 패스
					v[j] = true;								// 경사로를 설치할 수 있다면 방문처리
				}
			}else if(height[i] + 1 == height[i + 1]) {			// 현재 칸의 높이가 다음 칸보다 1 작다면 오르막 경사로 준비
				for(int j = i; j > i - L; j--) {				// 현재 칸부터 높이 L만큼 왼쪽으로 체크
					if(j < 1) return false;						// 범위 아웃
					if(v[j]) return false;						// 이미 설치
					if(height[i] != height[j]) return false;	// 현재 칸부터 경사로 설치기 때문에 높이 같은지 비교
					v[j] = true;								// 설치 되면 방문처리
				}
			}else return false;
		}
//		System.out.println(r + " " + c);
//		System.out.println(Arrays.toString(height));
		return true;
	}
}
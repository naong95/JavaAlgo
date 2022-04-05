package a0404;

import java.io.*;
import java.util.*;

public class Solution_d9_1767_프로세서연결하기_대전_5반_허진혁 {
	static int N, max, totalCnt, min, map[][];
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i==0||i==N-1||j==0||j==N-1) && map[i][j] == 1) continue;
					
					if(map[i][j]==1) {
						list.add(new int[] {i, j});
						totalCnt++;
					}
				}
			}
			go(0,0);
			
			System.out.println("#" + tc + " " + min);
		}

		br.close();
	}
	private static void go(int index, int cCnt) {
		// 부분집합으로 코어 전선놓기 시도, cCnt: 전원과 연결된 코어수
		if(index == totalCnt) {
			int res = getLength();
			if(max < cCnt) {
			   max = cCnt;
			   min = res;
			} else if(max == cCnt) { // 최대 연결 코어 수가 같다면
				if(min > res) min = res;
			}
			return;
		}
		
		int[] core = list.get(index);
		int i = core[0];
		int j = core[1];
		// 전선을 놓아보기(4방향으로)
		for(int d = 0; d < 4; d++) {
			if(isAvailable(i, j, d)) {// 현재 코어의 i, j 위치에서 d 방향으로 전선을 놓을 수 있다면
				setStatus(i, j, d, 2); // 전선 놓기
				go(index + 1, cCnt + 1);
				setStatus(i, j, d, 0);// 전선 지우기
			}
		}
		// 전선 놓지 않기
		go(index + 1, cCnt);
	}
	private static boolean isAvailable(int i, int j, int d) {
		int ni = i, nj = j;
		while (true) {
			ni += di[d];
			nj += dj[d];
			if(ni < 0 || ni >= N || nj < 0 || nj >= N) break;
			// 다른 코어나 전선을 만나면 return false
			if(map[ni][nj] > 0) return false;
		}
		return true;
	}
	private static void setStatus(int i, int j, int d, int s) {
		int ni = i, nj = j;
		while(true) {
			ni += di[d];
			nj += dj[d];
			if(ni < 0 || ni >= N || nj < 0 || nj >= N) break;
			map[ni][nj] = s;
		}
	}
	private static int getLength() {// 놓아진 전선의 길이의 합 계산
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) lCnt++;
			}
		}
		return lCnt;
	}
}
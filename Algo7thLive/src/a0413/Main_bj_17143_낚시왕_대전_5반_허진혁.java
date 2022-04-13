package a0413;
import java.io.*;
import java.util.*;
/*
낚시왕이 오른쪽으로 한 칸 이동한다.
낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
상어가 이동한다.

첫째 줄에 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)
상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 로 이루어져 있다
(r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다
d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다

상어가 배열의 범위 끝에 도달했을 때 방향을 바꿔서 진행한다는 조건을 놓쳤다 --> 문제를 꼼꼼하게 읽자
 */
public class Main_bj_17143_낚시왕_대전_5반_허진혁 {
	
	static int[] di = {0,1,-1,0,0};// 0 상 하 우 좌
	static int[] dj = {0,0,0,1,-1};
	
	static int R, C, M, map[][][];
	static class shark{
		int r;// 행
		int c;// 열
		int s;// 속도
		int d;// 방향
		int z;// 크기
		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static List<shark> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());// 세로
		C = Integer.parseInt(st.nextToken());// 가로
		M = Integer.parseInt(st.nextToken());// 상어의 수
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new shark(r, c, s, d, z));
		}
		int ans = 0;
		for(int i = 1; i <= C; i++) {
			map = new int[R + 1][C + 1][M + 1];
			moveDel();
			ans += seize(i);
		}
		System.out.println(ans);
	}
	private static void moveDel() {// 상어가 이동하고 잡아먹는 함수
		shark tmp = null;
		for(int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			int ni = 0;
			int nj = 0;
			for(int j = 0; j < tmp.s; j++) {
				ni = tmp.r + di[tmp.d];
				nj = tmp.r + dj[tmp.d];
				if(ni < 0 || ni >= R || nj < 0 || nj >= C) continue;
				tmp.r = ni;
				tmp.c = nj;
			}
			map[tmp.r][tmp.c][i] = tmp.z;
		}
		List<shark> tList = new LinkedList<shark>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				int max = 0;
				int idx = 0;
				for(int k = 0; k < M; k++) {
					if(max < map[i][j][k]) {
						max = map[i][j][k];
						idx = k;
					}
				}
				tList.add(list.get(idx));
				map[i][j][M] = max;
			}
		}
		list = tList;
	}
	private static int seize(int c) {// 낚시왕이 물고기 잡는 함수
		int res = 0;
		for(int i = 1; i <= R; i++) {
			if(map[i][c][M] != 0) {
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j).r == i && list.get(j).c == c) {
						res += list.get(j).z;
						list.remove(j);
						return res;
					}
				}
			}
		}
		return res;
	}
}
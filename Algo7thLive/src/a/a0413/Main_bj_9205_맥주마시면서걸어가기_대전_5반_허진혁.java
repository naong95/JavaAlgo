package a.a0413;
import java.io.*;
import java.util.*;
/*
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)
각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).
다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다.
각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)
송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
 */

public class Main_bj_9205_맥주마시면서걸어가기_대전_5반_허진혁 {
	static class pos{
		int x;
		int y;
		boolean v;
		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static pos home, convi[], festi;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());// 편의점 개수
			convi = new pos[N];
			st = new StringTokenizer(br.readLine(), " ");
			home = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				convi[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			festi = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			bfs();
		}
		br.close();
	}
	
	private static void bfs() {
		if(cal(home, festi) <= 1000) {
			System.out.println("happy");
			return;
		}
		Queue<pos> q = new ArrayDeque<>();
		home.v = true;
		q.offer(home);
		while(!q.isEmpty()) {
			pos cur = q.poll();
			if(cal(cur, festi) <= 1000) {
				System.out.println("happy");
				return;
			}
			for(int i = 0; i < N; i++) {
				if(!convi[i].v && cal(cur, convi[i]) <= 1000) {
					convi[i].v = true;
					q.offer(convi[i]);
				}
			}
		}
		System.out.println("sad");
		return;
	}
	
	private static int cal(pos a, pos b) {
		int distance = 0;
		distance += Math.abs(b.y - a.y) + Math.abs(b.x - a.x);
		return distance;
	}
}
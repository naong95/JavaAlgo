package a0401;

import java.util.*;
import java.io.*;

public class Main_bj_4485_녹색옷입은애가젤다지_대전_5반_허진혁 {
	/*
	하여튼 젤다...아니 링크는 이 동굴의 반대편 출구,
	제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다. 
	동굴의 각 칸마다 도둑루피가 있는데,
	이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다. 
	
	링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며,
	한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
	
	링크가 잃을 수밖에 없는 최소 금액은 얼마일까?
	*/
	static class Vertex implements Comparable<Vertex> {
		int i, j, minMinusRupee;

		public Vertex(int i, int j, int minMinusRupee) {
			super();
			this.i = i;
			this.j = j;
			this.minMinusRupee = minMinusRupee;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minMinusRupee - o.minMinusRupee;
		}

	}
	
	private static int dijkstra() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		minusRupee[0][0] = cave[0][0];
		pq.offer(new Vertex(0, 0, cave[0][0]));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj < N) {
					if(minusRupee[ni][nj] > minusRupee[cur.i][cur.j] + cave[ni][nj]) {
						minusRupee[ni][nj] = minusRupee[cur.i][cur.j] + cave[ni][nj];
						pq.offer(new Vertex(ni, nj, minusRupee[ni][nj]));
					}
				}
			}
		}
		return minusRupee[N - 1][N - 1];
	}
	
	static int N, cave[][], minusRupee[][];
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;// 0 들어오면 입력 종료
			
			cave = new int[N][N];// 동굴 생성
			minusRupee = new int[N][N];// 잃는 루피
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {// 동굴에 도둑 루피 대입
					cave[i][j] = Integer.parseInt(st.nextToken());
					minusRupee[i][j] = Integer.MAX_VALUE;
					// 최솟값 찾아야하므로 최댓값 대입
				}
			}
			num++;
			sb.append("Problem " + num + ": " + dijkstra() + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
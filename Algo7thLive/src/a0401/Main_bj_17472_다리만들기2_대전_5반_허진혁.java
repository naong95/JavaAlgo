package a0401;

import java.util.*;
import java.io.*;

public class Main_bj_17472_다리만들기2_대전_5반_허진혁 {

	/*
	섬의 개수를 센다.
	섬끼리 연결되는 모든 다리를 생성한다.
	섬과 다리를 간선 리스트로 표현한다.
	최소신장트리로 가장 비용이 적은(다리의 길이가 짧은) 조합을 출력한다.
	
	가로 다리는 가로의 끝이 두 섬과 닿아야한다. 세로 다리는 세로의 끝이.
	다리의 길이는 2 이상이어야 한다.
	다리의 방향은 중간에 바뀔 수 없다.
	*/
	static int N, M, map[][], land;
	static boolean[][] v;
	static int[] parents;
	static List<Edge> edgeList;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}
	
	static void makeSet() {
		parents = new int[land + 1];
		for (int i = 1; i <= land; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);// path compression
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		edgeList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		v = new boolean[N][M];
		land = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!v[i][j] && map[i][j] == 1) countLand(i, j);
			}
		}
		for(int i = 0; i < N; i++) {// 가로 다리
			int from = 0;
			int to = 0;
			int len = 0;
			for(int j = 0; j < M - 1; j++) {
				if(map[i][j] != 0) {
					from = map[i][j];
				}
				else {
					if(map[i][j] == 0) len++;
					if(map[i][j + 1] != from && map[i][j + 1] != 0) {
						to = map[i][j + 1];
						if(len > 1 && from != 0) {
							edgeList.add(new Edge(from, to, len));
						}
						from = 0;
						to = 0;
						len = 0;
					}
				}
			}
		}
		for(int j = 0; j < M; j++) {// 세로 다리
			int from = 0;
			int to = 0;
			int len = 0;
			for(int i = 0; i < N - 1; i++) {
				if(map[i][j] != 0) {
					from = map[i][j];
				}
				else {
					if(map[i][j] == 0) len++;
					if(map[i + 1][j] != from && map[i + 1][j] != 0) {
						to = map[i + 1][j];
						if(len > 1 && from != 0) {
							edgeList.add(new Edge(from, to, len));
						}
						from = 0;
						to = 0;
						len = 0;
					}
				}
			}
		}
		
		Collections.sort(edgeList);
		makeSet();
		
		long result = 0, cnt = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == land - 1) break;
			}
		}
		if(result == 0) System.out.println(-1);
		else System.out.println(result);
		
		br.close();
	}
	
	static void countLand(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		map[i][j] = land + 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0 <= ni && ni < N && 0 <= nj && nj <M && !v[ni][nj]) {
					if(map[ni][nj] == 1) {
						v[ni][nj] = true;
						map[ni][nj] = land + 1;
						q.offer(new int[] {ni, nj});
					}
					v[ni][nj] = true;
				}
			}
		}
		if(q.isEmpty()) land++;
	}
}
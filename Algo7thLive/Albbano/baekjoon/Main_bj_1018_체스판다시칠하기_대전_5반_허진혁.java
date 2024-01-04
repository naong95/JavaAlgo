package baekjoon;
import java.util.*;
import java.io.*;
/*
B == 66, W == 87
*/
public class Main_bj_1018_체스판다시칠하기_대전_5반_허진혁 {
	public static int check(char[][] map) {
		int wcnt = 0;
		int bcnt = 0;
		char start = 'W';
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j+=2) {
				if(map[i][j] != start) {
					wcnt++;
				}
			}
			for(int j = 1; j < 8; j+=2) {
				if(map[i][j] == start) {
					wcnt++;
				}
			}
		}
		start = 'B';
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j+=2) {
				if(map[i][j] != start) {
					bcnt++;
				}
			}
			for(int j = 1; j < 8; j+=2) {
				if(map[i][j] == start) {
					bcnt++;
				}
			}
		}
		return Math.min(wcnt, bcnt);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1018.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] tmap = new char[n][m];
		for(int i = 0; i < n; i++) {
			tmap[i] = br.readLine().toCharArray();
		}
		char[][] map = new char[8][8];
		
		for(int i = 0; i < n - 7; i++) {
			for(int j = 0; j < m - 7; j++) {
			}
		}
		
		br.close();
	}
}
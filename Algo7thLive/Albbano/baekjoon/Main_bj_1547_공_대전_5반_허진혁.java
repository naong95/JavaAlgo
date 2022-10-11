package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1547_공_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1547.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a = -1;
		int b = -1;
		int[] ball = {0, 1, 0, 0};
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(ball[a] == ball[b]) continue;
			else {
				if(ball[a] == 1) {
					ball[a]--;
					ball[b]++;
				} else {
					ball[a]++;
					ball[b]--;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			if(ball[i] == 1) System.out.println(i);
		}
		
		br.close();
	}
}
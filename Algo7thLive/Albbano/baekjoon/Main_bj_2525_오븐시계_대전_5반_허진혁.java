package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_2525_오븐시계_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_2525.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int curT = Integer.parseInt(st.nextToken());
		int curM = Integer.parseInt(st.nextToken());
		int cm = Integer.parseInt(br.readLine());
		
		int t = cm / 60;
		int m = cm % 60;
		
		curT += t;
		curM += m;
		if(curM >= 60) {
			curT++;
			curM %= 60;
		}
		if(curT >= 24) {
			curT %= 24;
		}
		System.out.println(curT + " " + curM);
		
		br.close();
	}
}
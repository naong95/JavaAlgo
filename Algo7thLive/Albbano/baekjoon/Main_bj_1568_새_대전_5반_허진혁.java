package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1568_새_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bird = Integer.parseInt(br.readLine());
		int song = 1;
		int sec = 0;
		
		while(bird > 0) {
			bird -= song;
			song++;
			if(bird < song) song = 1;
			sec++;
		}
		
		System.out.println(sec);
		br.close();
	}
}
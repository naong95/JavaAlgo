package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1264_모음의개수_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1264.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char[] ca = br.readLine().toCharArray();
			if(ca[0] == '#') break;
			
			int count = 0;
			for(int i = 0; i < ca.length; i++) {
				if(ca[i] == 'a' || ca[i] == 'e' || ca[i] == 'i' || ca[i] == 'o' || ca[i] == 'u' || 
				   ca[i] == 'A' || ca[i] == 'E' || ca[i] == 'I' || ca[i] == 'O' || ca[i] == 'U') {
					count++;
				}
			}
			
			System.out.println(count);
		}
		
		br.close();
	}
}
package baekjoon;
import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1259_팰린드롬수_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1259.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char[] ca = br.readLine().toCharArray();
			if(ca[0] == '0') break;
			boolean f = true;
			for(int i = 0; i < ca.length / 2; i++) {
				if(ca[i] != ca[ca.length - i - 1]) {
					f = false;
					break;
				}
			}
			
			if(f) System.out.println("yes");
			else System.out.println("no");
		}
		
		br.close();
	}
}
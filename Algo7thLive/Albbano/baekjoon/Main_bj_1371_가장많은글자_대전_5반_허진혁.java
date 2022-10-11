package baekjoon;

import java.util.*;
import java.io.*;
/*

*/
public class Main_bj_1371_가장많은글자_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_1371.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 'a' == 49
		int[] countArray = new int[26];
		while(br.ready()) {
			char[] ca = br.readLine().trim().toCharArray();
			for(int i = 0; i < ca.length; i++) {
				if(ca[i] != ' ') {
					countArray[ca[i] - '0' - 49]++;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 26; i++) {
			if(answer < countArray[i]) answer = countArray[i];
		}
		
		for(int i = 0; i < 26; i++) {
			if(countArray[i] == answer) System.out.print((char)(i + '0' + 49));
		}
		
		br.close();
		}
	}
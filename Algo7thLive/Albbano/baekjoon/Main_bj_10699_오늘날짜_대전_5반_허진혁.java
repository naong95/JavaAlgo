package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*

*/
public class Main_bj_10699_오늘날짜_대전_5반_허진혁 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("albbanoRes/input_bj_10699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LocalDate now = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		System.out.println(now.format(formatter));

		br.close();
	}
}
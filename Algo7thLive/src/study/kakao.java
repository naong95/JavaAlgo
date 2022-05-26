package study;
import java.util.*;
import java.io.*;

public class kakao {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] birth = {"1899-13-31", "19001231", "2001-09-4", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000----29","-2019-12-29-", "1945--10-31", "----------", "20000-123-567"};
		System.out.println(solution(birth));
		br.close();
	}

	private static int solution(String[] birth) {
		int answer = -1;
		char[] ca;
		StringBuilder sb;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < birth.length; i++) {
			if(birth[i].length() > 10 || birth[i].length() < 8) continue;
			ca = birth[i].toCharArray();
			if(ca[4] != '-') continue;
			sb = new StringBuilder("");
			for(int j = 0; j < 4; j++) {
				sb.append(ca[j]);
			}
			String year = sb.toString();
			if(!year.chars().allMatch( Character::isDigit )) continue;
			if(Integer.parseInt(sb.toString()) < 1900 | Integer.parseInt(sb.toString()) > 2021) continue;
			
			
			ca = birth[i].toCharArray();
			if(ca[6] == '-') birth[i] = birth[i].substring(0, 5) + "0" + birth[i].substring(5, birth[i].length());
			ca = birth[i].toCharArray();
			sb = new StringBuilder("");
			for(int j = 5; j < 7; j++) {
				sb.append(ca[j]);
			}
			String month = sb.toString();
			if(!month.chars().allMatch( Character::isDigit )) continue;
			if(Integer.parseInt(month) > 12 | Integer.parseInt(month) < 1) continue;
			
			sb = new StringBuilder("");
			for(int j = 5; j < 7; j++) {
				sb.append(ca[j]);
			}
			String s = birth[i];
			if(s.length() == 9) birth[i] = birth[i].substring(0, 8) + "0" + birth[i].substring(8, birth[i].length());
			ca = birth[i].toCharArray();
			sb = new StringBuilder("");
			for(int j = 8; j < 10; j++) {
				sb.append(ca[j]);
			}
			String day = sb.toString();
			int yy = Integer.parseInt(year);
			int mm = Integer.parseInt(month);
			int dd = Integer.parseInt(day);
			
			
			
			
			
			
			
			list.add(birth[i]);
		}
		System.out.println(list);
		return answer;
	}
}
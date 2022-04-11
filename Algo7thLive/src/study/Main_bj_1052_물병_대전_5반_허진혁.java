package study;

import java.util.*;
import java.io.*;

/*
처음에 모든 물병에는 물이 1리터씩 들어있다 

먼저 같은 양의 물이 들어있는 물병 두 개를 고른다. 
그 다음에 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다. 
이 방법을 필요한 만큼 계속 한다.

N개로 K개를 넘지않는 비어있지 않은 물병을 만드는 것이 불가능할 수도 있다. 
다행히도, 새로운 물병을 살 수 있다. 상점에서 사는 물병은 물이 1리터 들어있다.
*/

public class Main_bj_1052_물병_대전_5반_허진혁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());// 소지하고 있는 물병 수
		int K = Integer.parseInt(st.nextToken());// 만들어야 하는 물병 수
		
		int buy = 0;
		int count = 0;
		while(true) {
			if(N % 2 == 1){
				buy += Math.pow(2, count);
				count++;
			}
			if(N <= K) {
				System.out.println(buy);
				break;
			}
			N++;
			buy++;
		}
		br.close();
	}
	
}
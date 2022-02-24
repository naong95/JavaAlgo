package a0224;
import java.io.*;
import java.util.*;
public class String_KMPTest_sc {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] text = "ababababcababaca".toCharArray();//sc.next().toCharArray();
		char[] pattern = "ababaca".toCharArray();//sc.next().toCharArray();
		int tLength = text.length, pLength = pattern.length;
		System.out.println(Arrays.toString(text));
		System.out.println(Arrays.toString(pattern));
		
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1]; 
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	    }
	    System.out.println(Arrays.toString(pi));
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) {
					cnt++;
					list.add((i+1)-pLength);  
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}
}
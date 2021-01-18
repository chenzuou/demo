package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Demo2 {
	public static void main(String[] args) {
		String s = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		int count = 0;
		char[] a = s.toCharArray();
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<a.length;i++) {
			int pos = temp.indexOf(String.valueOf(a[i]));
			if (pos != -1) {
				if (count < temp.length()) {
					count = temp.length();
				}
				temp.delete(0, pos+1);
			}
			temp.append(a[i]);
		}
		if(count < temp.length()){
			count++;
		}
		System.out.println(count);
	}

}

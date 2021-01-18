package com.example.demo;

import org.apache.commons.lang3.StringUtils;

public class Demo3 {

	public static void main(String[] args) {
		String result = "";
		String s = "bb";
		StringBuffer sb = new StringBuffer(s);
		char[] a = s.toCharArray();
		for(int i=0;i<a.length;i++){
			int pos = s.indexOf(a[i],i+1);
			while(pos != -1){
				String temp = s.substring(i,pos+1);
				if(temp.length() > result.length() && new StringBuffer(temp).reverse().toString().equals(temp)){
					result = temp;
				}
				pos = s.indexOf(a[i],pos+1);
			}
		}
		if(result == null || "".equals(result)){
			result = s.substring(0,1);
		}
		System.out.println(result);
	}
}

package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 描述：三个空瓶换一瓶饮料问题
 * @author : paul
 * @date   : 2020/6/8/008 17:56
 */
public class Demo {
	public static int test(int shang, int yushu, int result){
		int a = shang/3;
		int b = shang%3;
		result = result + a;
		yushu = yushu + b;
		if(a >= 3){
			result = test(a, yushu, result);
		}else{
			//剩余的空瓶
			yushu = yushu + a;
			if(yushu >= 3){
				result = test(yushu, 0, result);
			}else if(yushu == 2){
				result = result + 1;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		List<Integer> arr = new ArrayList();
		while(true){
			Scanner input=new Scanner(System.in);
			int n=input.nextInt();
			if(n != 0){
				arr.add(n);
			}else{
				for(int shang : arr){
					System.out.println(test(shang,0,0));
				}
				break;
			}
		}
	}

//	public int lastStoneWeight(int[] stones) {
//		List<int[]> stonesList = Arrays.asList(stones);
//		int x = 0;
//		int y = 0;
//		for(int i=0;i<stonesList.size();i++){
//			if(stonesList.get(i) > y){
//				y = stones[i];
//			}
//		}
//	}
}

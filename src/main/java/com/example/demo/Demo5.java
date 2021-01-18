package com.example.demo;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20191230.RecognizeIdentityCardRequest;
import com.aliyuncs.ocr.model.v20191230.RecognizeIdentityCardResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		a=a++;
		b++;
		c=++c;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d++);
//		int count = 0;
//		int num=0;
//		for(int i=0;i<=100;i++){
//			num = num+i;
//			count=count++;
//		}
//		System.out.println(num*count);
//		try {
//			Thread a = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("a");
//				}
//			});
//			Thread b = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("b");
//				}
//			});
//			Thread c = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("c");
//				}
//			});
////			a.start();
////			a.join();
////			b.start();
////			b.sleep(3000);
////			b.join();
////			c.start();
//
//			ExecutorService executor = Executors.newSingleThreadExecutor();
//			executor.submit(a);
//			executor.submit(b);
//			executor.submit(c);
//			//结束该线程池的生命周期
//			executor.shutdown();
//			System.out.println("11111111");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		int[][] a = {{1,-324690837,-72487934},{1,-723504364,-369145172},{2,-324690837},
//				{1,724101438,-30727452},{1,366967562,290286156},{2,366967562},
//				{1,-21417066,-450706222},{1,-484359960,-121414361},{1,-629538923,-759874959},
//				{1,-461538894,749719150},{1,-338664886,-3080586},{2,522415046},{1,134352387,-391032350},
//				{1,283492390,210901529},{2,-328994470},{2,-254674447},{2,85161833},{1,36899859,-561167545},
//				{1,-232060336,889831435},{1,-848557701,-189598178},{2,-81051921},{1,57162090,-193776405},
//				{1,157908494,-941008658},{2,-21417066},{2,-485579587},{2,449908952},{1,12002448,-273547528},
//				{1,-267371849,634867878},{1,128963067,102756157},{2,36899859},{2,145140817},{2,335181121},
//				{1,89294557,-213039610},{2,204879021},{2,36899859},{2,-371773103},{1,-354568989,-788098655},
//				{2,283492390},{2,148848181},{1,641416456,-646693824},{1,-970438681,341383327},{1,452656493,-68334619},
//				{1,209021588,229415889},{1,580338695,-286744639},{1,263639066,-99669610},{1,-586507345,255143085},
//				{2,89294557},{2,209021588},{1,888670782,-378802985}};
//		int[][] b = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
//		int[] result = LRU(b,3);
//		for(int value : result){
//			System.out.println(value);
//		}


		//		DefaultProfile profile = DefaultProfile.getProfile(
//				"cn-shanghai",
//				"51LpLjTUl2YiN0nq",
//				"pYMRfxP1uSTlm8VzMqQrecbkGQmO4H");
//		IAcsClient client = new DefaultAcsClient(profile);
//
//		RecognizeIdentityCardRequest request = new RecognizeIdentityCardRequest();
//		request.setRegionId("cn-shanghai");
//		request.setSide("face");
//		request.setImageURL("https://vdaifu-idcard.oss-cn-shanghai.aliyuncs.com/sfz/2.jpg");
//
//		try {
//			RecognizeIdentityCardResponse response = client.getAcsResponse(request);
//			System.out.println(new Gson().toJson(response));
//		} catch (ServerException e) {
//			e.printStackTrace();
//		} catch (ClientException e) {
//			System.out.println("ErrCode:" + e.getErrCode());
//			System.out.println("ErrMsg:" + e.getErrMsg());
//			System.out.println("RequestId:" + e.getRequestId());
//
//		}
	}

	public static int[] LRU (int[][] operators, int k) {
		// write code here
		List<Integer> beforeList = new ArrayList();
		beforeList.toArray(new String[3]);
		List<Integer> resultList = new ArrayList();
		LinkedHashMap<Integer,Integer> save = new LinkedHashMap();
		for(int i=0;i<operators.length;i++){
			if(operators[i][0] == 1){
				//set
				if(save.size() >= k){
					save.remove(save.entrySet().iterator().next().getKey());
				}
				save.remove(operators[i][1]);
				save.put(operators[i][1], operators[i][2]);
			}else if(operators[i][0] == 2){
				//get
				Integer value = save.get(operators[i][1]);
				if(value == null){
					resultList.add(-1);
				}else{
					resultList.add(value);
					save.remove(operators[i][1]);
					save.put(operators[i][1], value);
				}
			}
		}
		int[] result = null;
		if(resultList != null){
			result = new int[resultList.size()];
			for(int i=0;i<resultList.size();i++){
				result[i] = resultList.get(i);
			}
		}
		return result;
	}

	public static int minOperations(String[] logs) {
		int result = 0;
		for(int i=0;i<logs.length;i++){
			if(result != 0 && "../".equals(logs[i])){
				result--;
			}else if("./".equals(logs[i])){
				continue;
			}else{
				result++;
			}
		}
		return result;
	}

}

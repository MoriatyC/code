package com.sie.my_crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
public class Main {
	public static void main(String[] args) {
		
		List<Model> list = new ArrayList<>();
		String url = "http://gs.dlut.edu.cn/index/zytz.htm";
		String result = MyCrawler.getPage(url);
		Pattern pat = Pattern.compile("1/(\\d+)");
		Matcher matcher = pat.matcher(result);
		int page = 0;
		boolean isFirst = true;
		if(matcher.find())
		{
			page = Integer.valueOf(matcher.group(1));
			list = MyCrawler.extract(result);
			isFirst = false;
			for(Model model: list)
			{
				Util.writeFile(model.writeString(), "E:\\temp\\content.txt", true);
			}
		}
		else
		{
			System.out.println("查找失败");
		}
//		for(int i = 2; i <= page; i++)
//		{
//			int temp = i;
//			startTime = System.currentTimeMillis();
//			while(--temp > 0)
//			{
//				url = "http://gs.dlut.edu.cn/index/zytz/" + temp + ".htm";
//				result = MyCrawler.getPage(url);
//				list = MyCrawler.extract(result);
////				for(Model m: list)
////				{
////					System.out.println(m);
////				}
//			}
//			endTime = System.currentTimeMillis();
//			System.out.println("程序运行时间：" + 1.0*(endTime - startTime)/i + "ms");
//		}
		while(--page > 140)
		{
			url = "http://gs.dlut.edu.cn/index/zytz/" + page + ".htm";
			System.out.println(url);
			result = MyCrawler.getPage(url);
			list = MyCrawler.extract(result);
//			//存储
			for(Model model: list)
			{
				Util.writeFile(model.writeString(), "E:\\temp\\content.txt", true);
			}
		}
		
	}

}

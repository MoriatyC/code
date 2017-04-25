package com.sie.my_crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
	static File file;
		public static boolean createNewFile(String filePath){
			boolean isSuccess = false;
			String filePathTurn = filePath.replaceAll("\\\\","/");
			//java层\\\\-》 string层 \\ ->regx层\（regex将匹配字符串的打印结果所以路径中的\\将匹配）
			int index = filePathTurn.lastIndexOf("/");
			String dir = filePathTurn.substring(0, index);
			//create dir
			File fileDir = new File(dir);
			isSuccess = fileDir.mkdirs();
			//create file
			file = new File(filePathTurn);
			try {
				isSuccess = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				isSuccess = false;
				e.printStackTrace();
			}
			return isSuccess;
	}
		public static boolean writeFile(String content, String filePath, boolean isAppend){
			boolean isSuccess = createNewFile(filePath);
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(file,isAppend);
				fileWriter.write(content);
				fileWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				isSuccess = false;
				e.printStackTrace();
			} finally{
				try {
					if(fileWriter != null)
					{
						fileWriter.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return isSuccess;
		}
}

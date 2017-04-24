package com.DLUT.SIE.my_crawler;

import java.util.ArrayList;
import java.util.List;

public class Model 
{
	String title;
	String webUrl;
	String text;
	public Model(){
		title = "";
		webUrl = "";
	    text = "";
	}
    public String toString(){
    	return "title:" + title + "\n" + "URL:" + webUrl + "\n" + "新闻内容:" + text; 
    }
    public String writeString(){
    	String result = "";
    	result += "标题" + title + "\r\n";
    	result += "链接" + webUrl + "\r\n";
    	result += "内容" + text + "\r\n\r\n";
    	return result;
    }
}

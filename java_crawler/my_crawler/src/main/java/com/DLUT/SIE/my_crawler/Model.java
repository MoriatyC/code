package com.DLUT.SIE.my_crawler;

import java.util.ArrayList;
import java.util.List;

public class Model 
{
	String title;
	String webUrl;
	List<String> text;
	public Model(){
		title = "";
		webUrl = "";
		List<String> text = new ArrayList<>();
	}
    public String toString(){
    	return "title:" + title + "\n" + "URL:" + webUrl + "\n" + "新闻内容:" + text; 
    }
}

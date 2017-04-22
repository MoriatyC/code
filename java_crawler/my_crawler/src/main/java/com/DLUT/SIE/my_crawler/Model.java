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
}

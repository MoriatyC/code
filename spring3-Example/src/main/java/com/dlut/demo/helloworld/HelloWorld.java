package com.dlut.demo.helloworld;

public class HelloWorld{

    private String name;

    public void setName(String n){
      this.name=n;
    }

    /*
     *创建打印Hello方法
     */
    public void printHello(){
    System.out.println("The first Spring 3:hello"+name);

    }
  }
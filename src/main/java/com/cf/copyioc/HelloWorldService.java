package com.cf.copyioc;

public class HelloWorldService {

    private String text;

    public void helloService(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.cf.copyioc.service;


public class OutputService {

    private HelloWorldService helloWorldService;

    public OutputService() {
        System.out.println("初始化了");
    }

    public void output(String text) {
        System.out.println("text");
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}

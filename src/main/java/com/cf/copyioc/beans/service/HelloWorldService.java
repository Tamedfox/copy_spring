package com.cf.copyioc.beans.service;

public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloService(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}

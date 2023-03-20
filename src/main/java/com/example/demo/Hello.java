package com.example.demo;

public class Hello {
    private String message;
    public Hello(String message){
        this.message=message;
    }

    public void setMessage(String str){
        this.message=str;
    }

    public String toString(){
        return this.message;
    }

}

package com.bytecodedl.benchmark.demo;

public class TaintDemo2 {
    public static void main(String[] args) {
        TaintDemo2 demo = new TaintDemo2();
        String name = demo.Source();
        demo.test1(name);
    }

    public void test1(String name){
        String sql = "select * from user where name='" + name + "'";
        sql = Sanitize(sql);
        Sink(sql);
    }

    public void Sink(String param){

    }

    public String Sanitize(String param){
        String ret = param.replace('\'', '`');
        return ret;
    }

    public String Source(){
        return "tainted name";
    }
}

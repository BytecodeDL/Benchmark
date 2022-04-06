package com.bytecodedl.benchmark.demo;

public class TaintDemo3 {
    public static void main(String[] args) {
        TaintDemo3 demo = new TaintDemo3();
        String name = demo.Source();
        demo.test1(name);
    }

    public void test1(String name){
        String sql0= "select * from user where name='" + name + "'";
        String sql1 = sql0;
        String sql = Sanitize(sql1);
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

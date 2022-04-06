package com.bytecodedl.benchmark.demo;

/**
 * name parameter is taint source like spring mvc request handler method
 */
public class TaintDemo1 {
    public static void main(String[] args) {
        TaintDemo1 demo = new TaintDemo1();
        String name = demo.Source();
        demo.test1(name);
    }

    public void test1(String name){
        String sql = "select * from user where name='" + name + "'";
        Sink(sql);
    }

    public void Sink(String param){

    }

    public String Source(){
        return "tainted name";
    }
}

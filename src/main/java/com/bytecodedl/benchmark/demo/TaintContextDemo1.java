package com.bytecodedl.benchmark.demo;

public class TaintContextDemo1 {
    class A{
        public A(){}

        public A append(String str){
            return this;
        }
    }

    public void test1(String arg){
        A a1 = new A();
        A a2 = a1.append(arg);

        A b1 = new A();
        A b2 = b1.append("123");
    }
}



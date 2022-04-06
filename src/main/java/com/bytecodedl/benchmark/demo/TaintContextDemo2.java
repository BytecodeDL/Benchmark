package com.bytecodedl.benchmark.demo;

public class TaintContextDemo2 {
    class A{
        public A(){}

        public B id(B b){
            return b;
        }
    }

    class B{}

    public void test1(B argB){
        A a = new A();
        B b1 = new B();
        B b2 = a.id(b1);
        B b3 = a.id(argB);
    }
}

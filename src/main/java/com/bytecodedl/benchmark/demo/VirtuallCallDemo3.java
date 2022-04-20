package com.bytecodedl.benchmark.demo;

public class VirtuallCallDemo3 implements VirtualCallInterface1 {
    public void foo() {
        foo3();
    }

    public void foo3(){
        VirtualCallDemo1.target();
    }
}

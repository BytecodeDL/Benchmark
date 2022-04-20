package com.bytecodedl.benchmark.demo;

public class VirtualCallDemo2 implements VirtualCallInterface1 {
    public void foo() {
        VirtualCallDemo1.target();
    }
}

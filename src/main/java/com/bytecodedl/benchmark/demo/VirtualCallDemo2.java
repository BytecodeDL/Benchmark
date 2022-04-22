package com.bytecodedl.benchmark.demo;

public class VirtualCallDemo2 implements VirtualCallInterface1 {
    public void foo(String fooArg2) {
        VirtualCallDemo1.target(fooArg2);
    }
}

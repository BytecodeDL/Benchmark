package com.bytecodedl.benchmark.pointsto.helper;

public class N {
    public String value = "";
    public N next;

    public N() {
        Benchmark.alloc(2);
        next = new N();
    }
}
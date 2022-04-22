package com.bytecodedl.benchmark.demo;

public class VirtuallCallDemo3 implements VirtualCallInterface1 {
    public void foo(String fooArg3) {
        foo3(fooArg3);
    }

    public void foo3(String foo3Arg3){
        VirtualCallDemo1.target(foo3Arg3);
    }
}

package com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc1;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

class Class {

    public static void method(){ /* do something*/}
    public static void method(int param){ /* do something*/}

    @DirectCall(name = "method", line = 12, resolvedTargets = "com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc1.Class;")
    public static void main(String[] args){
        Class.method();
    }
}

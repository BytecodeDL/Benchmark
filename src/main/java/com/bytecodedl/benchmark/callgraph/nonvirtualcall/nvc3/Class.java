package com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc3;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

class Class {

    private void method(){ /* do something*/}
    private void method(int num){ /* do something*/}

    @DirectCall(name = "method", line = 13, resolvedTargets = "com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc3.Class;")
    public static void main(String[] args){
        Class cls = new Class();
        cls.method();
    }
}
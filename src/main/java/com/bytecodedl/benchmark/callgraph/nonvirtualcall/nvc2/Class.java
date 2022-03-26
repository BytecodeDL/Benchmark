package com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc2;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

public class Class {

    public Class(){

    }

    @DirectCall(name = "<init>", line = 13, resolvedTargets = "com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc2.Class;")
    public static void main(String[] args){
        Class cls = new Class();
    }
}

package com.bytecodedl.benchmark.callgraph.virtualcall.vc1;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

class Class {

    public void target(){ }

    @DirectCall(name = "target", line = 12, resolvedTargets = "com.bytecodedl.benchmark.callgraph.virtualcall.vc1.Class")
    public static void main(String[] args){
        Class cls = new Class();
        cls.target();
    }
}

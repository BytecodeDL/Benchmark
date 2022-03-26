package com.bytecodedl.benchmark.callgraph.virtualcall.vc2;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

class Class {

    public void method(){ }

    @DirectCall(name = "method", line = 11, resolvedTargets = "com.bytecodedl.benchmark.callgraph.virtualcall.vc2.SubClass")
    public static void callMethod(Class cls) {
        cls.method();
    }

    public static void main(String[] args){
        callMethod(new SubClass());
    }
}

class SubClass extends Class {

    public void method() { }
}

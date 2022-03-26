package com.bytecodedl.benchmark.callgraph.virtualcall.vc3;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

interface Interface {
    void method();
}

class Class {

    public void method(){ }

    @DirectCall(name = "method", line = 15, resolvedTargets = {"com.bytecodedl.benchmark.callgraph.virtualcall.vc3.ClassImpl"}, prohibitedTargets ={"com.bytecodedl.benchmark.callgraph.virtualcall.vc3.Class"})
    public static void callOnInterface(Interface i){
        i.method();
    }

    public static void main(String[] args){
        callOnInterface(new ClassImpl());
    }
}

class ClassImpl implements Interface {
    public void method(){ }
}

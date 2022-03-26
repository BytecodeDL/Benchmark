package com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc4;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

class Class extends Superclass {

    @DirectCall(name = "method", line = 9, resolvedTargets = "com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc4.Rootclass")
    protected void method(){
        super.method();
    }

    public static void main(String[] args){
        Class cls = new Class();
        cls.method();
    }
}

class Superclass extends Rootclass {

}

class Rootclass {
    protected void method(){ /* do something relevant */ }
}

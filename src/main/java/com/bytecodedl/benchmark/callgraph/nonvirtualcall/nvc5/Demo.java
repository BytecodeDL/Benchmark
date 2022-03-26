package com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc5;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

public class Demo {

    public static void main(String[] args){
        new Sub().method();
    }
}

class Super {

    void method() { /* doSomething */ }
}

class Middle extends Super {

    void method() { /* doSomething */ }
}

class Sub extends Middle {

    @DirectCall(name="method", line=26, resolvedTargets = "com.bytecodedl.benchmark.callgraph.nonvirtualcall.nvc5.Middle;")
    void method() {
        super.method();
    }
}

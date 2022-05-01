package com.bytecodedl.benchmark.demo;

public class ContextSensitiveDemo1 implements ContextSensitive{
    public static void main(String[] args) {
        ContextSensitiveDemo1 demo1 = new ContextSensitiveDemo1();
        ContextSensitiveDemo2 demo2 = new ContextSensitiveDemo2();
        ContextSensitive demoInterface1 = demo1.foo(demo1);
        ContextSensitive demoInterface2 = demo1.foo(demo2);
        demoInterface1.func();
        demoInterface2.func();
    }

    @Override
    public ContextSensitive foo(ContextSensitive arg) {
        return arg;
    }

    @Override
    public String func() {
        String ret = "ContextSensitiveDemo1";
        return ret;
    }
}

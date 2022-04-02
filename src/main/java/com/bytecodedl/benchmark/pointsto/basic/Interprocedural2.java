package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.B;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Method2
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias in a method
 */
public class Interprocedural2 {

    public Interprocedural2() {}

    public void alloc(A x, A y) {
        x.f = y.f;
    }


    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.helper.A: void <init>()>/new com.bytecodedl.benchmark.pointsto.helper.B/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Interprocedural2: void main(java.lang.String[])>/x")
    public static void main(String[] args) {

        A a = new A();
        A b = new A();

        Benchmark.alloc(1);
        b.f = new B();
        Interprocedural2 m2 = new Interprocedural2();
        m2.alloc(a, b);

        B x = a.f;
        B y = b.f;
        Benchmark
                .test("x",
                        "{allocId:1, mayAlias:[x,y], notMayAlias:[a,b,m2], mustAlias:[x,y], notMustAlias:[a,b,m2]}");
    }
}


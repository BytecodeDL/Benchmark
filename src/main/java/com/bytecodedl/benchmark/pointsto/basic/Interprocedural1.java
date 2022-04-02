package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.B;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Method1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias in a static method
 */
public class Interprocedural1 {

    public static void alloc(A x, A y) {
        x.f = y.f;
    }

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.basic.Interprocedural1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.B/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Interprocedural1: void main(java.lang.String[])>/x")
    public static void main(String[] args) {

        A a = new A();
        A b = new A();

        Benchmark.alloc(1);
        b.f = new B();
        alloc(a, b);

        B x = a.f;
        B y = b.f;
        Benchmark.test("x",
                "{allocId:1, mayAlias:[x,y], notMayAlias:[a,b], mustAlias:[x,y], notMustAlias:[a,b]}");
    }
}

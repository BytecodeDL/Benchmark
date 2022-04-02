package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase ReturnValue1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias to a return value from a static method
 */
public class ReturnValue1 {

    public static A id(A x) {
        return x;
    }

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.ReturnValue1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.basic.ReturnValue1: void main(java.lang.String[])>/b")
    public static void main(String[] args) {

        Benchmark.alloc(1);
        A a = new A();
        A b = id(a);
        Benchmark.test("b",
                "{allocId:1, mayAlias:[a,b], notMayAlias:[], mustAlias:[a,b], notMustAlias:[]}");
    }
}

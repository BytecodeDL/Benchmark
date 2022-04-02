package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.B;
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
public class ReturnValue3 {

    public static A id(A x) {
        A y = new A();
        Benchmark.alloc(1);
        y.f = new B();
        return y;
    }

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.basic.ReturnValue3: com.bytecodedl.benchmark.pointsto.helper.A id(com.bytecodedl.benchmark.pointsto.helper.A)>/new com.bytecodedl.benchmark.pointsto.helper.B/0", var="<com.bytecodedl.benchmark.pointsto.basic.ReturnValue3: void main(java.lang.String[])>/x")
    public static void main(String[] args) {

        A a = new A();
        A b = id(a);
        B x = b.f;
        B y = a.f;
        Benchmark.test("x",
                "{allocId:1, mayAlias:[x], notMayAlias:[a,b,y], mustAlias:[x], notMustAlias:[a,b,y]}");
    }
}

package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Exception2
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description No alias in exception (exception never triggered)
 */
public class Exception2 {

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.generaljava.Exception2: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.generaljava.Exception1: void main(java.lang.String[])>/b")
    public static void main(String[] args) {

        A a = new A();
        Benchmark.alloc(1);
        A b = new A();

        try {
            Integer.parseInt("abc");
            a = b;

        } catch (RuntimeException e) {
            Benchmark.test("b",
                    "{allocId:1, mayAlias:[b], notMayAlias:[a], mustAlias:[b], notMustAlias:[a]}");
        }

    }
}

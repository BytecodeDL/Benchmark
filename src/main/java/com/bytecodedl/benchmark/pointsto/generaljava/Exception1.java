package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Exception1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias in exception
 */
public class Exception1 {

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.generaljava.Exception1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.generaljava.Exception1: void main(java.lang.String[])>/b")
    public static void main(String[] args) {

        Benchmark.alloc(1);
        A a = new A();
        A b = new A();

        try {
            b = a;
            throw new RuntimeException();

        } catch (RuntimeException e) {
            Benchmark.test("b",
                    "{allocId:1, mayAlias:[a,b], notMayAlias:[], mustAlias:[a,b], notMustAlias:[]}");
        }

    }
}

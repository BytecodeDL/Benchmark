package com.bytecodedl.benchmark.pointsto.sensitivity;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase ContextSensitivity1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Object sensitive alias from caller object (1-CS)
 */
public class ContextSensitivity1 {

    public ContextSensitivity1() {}

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.sensitivity.ContextSensitivity1: void test1()>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.sensitivity.ContextSensitivity1: void callee(com.bytecodedl.benchmark.pointsto.helper.A,com.bytecodedl.benchmark.pointsto.helper.A)>/@parameter1")
    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.sensitivity.ContextSensitivity1: void test2()>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.sensitivity.ContextSensitivity1: void callee(com.bytecodedl.benchmark.pointsto.helper.A,com.bytecodedl.benchmark.pointsto.helper.A)>/@parameter1")
    public void callee(A a, A b) {
        Benchmark.test("b",
                "{allocId:1, mayAlias:[a,b], notMayAlias:[], mustAlias:[a,b], notMustAlias:[]},"
                        + "{allocId:2, mayAlias:[a], notMayAlias:[b], mustAlias:[a], notMustAlias:[b]}");
    }

    public void test1() {
        Benchmark.alloc(1);
        A a1 = new A();
        A b1 = a1;
        callee(a1, b1);
    }

    public void test2() {
        A a2 = new A();
        Benchmark.alloc(2);
        A b2 = new A();
        callee(a2, b2);
    }

    public static void main(String[] args) {
        ContextSensitivity1 cs1 = new ContextSensitivity1();
        cs1.test1();
        cs1.test2();
    }
}

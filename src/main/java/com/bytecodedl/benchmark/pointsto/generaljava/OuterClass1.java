package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase OuterClass1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias from method in inner class
 */
public class OuterClass1 {

    public OuterClass1() {}

    public class InnerClass {
        private A a;

        public InnerClass(A a) {
            this.a = a;
        }

        public void alias(A x) {
            this.a = x;
        }
    }

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.generaljava.OuterClass1: void test()>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.generaljava.OuterClass1: void test()>/h")
    private void test() {
        Benchmark.alloc(1);
        A a = new A();
        A b = new A();

        InnerClass i = new InnerClass(a);
        i.alias(b);
        A h = i.a;
        Benchmark.test("h",
                "{allocId:1, mayAlias:[b,h], notMayAlias:[i,a], mustAlias:[b,a], notMustAlias:[i]}");
    }

    private static void main(String[] args) {
        OuterClass1 oc1 = new OuterClass1();
        oc1.test();
    }

}

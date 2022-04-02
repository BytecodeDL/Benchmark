package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.B;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Null1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Direct alias to null
 */
public class Null1 {

    public static void main(String[] args) {

        // No allocation site
        A h = new A();
        B a = h.getH();
        B b = a;
        Benchmark.test("b",
                "{NULLALLOC, mayAlias:[], notMayAlias:[b,a], mustAlias:[b,a], notMustAlias:[i]}");
        Benchmark.use(b);
    }
}

package com.bytecodedl.benchmark.pointsto.collections;

import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Array1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Array alias
 */
public class Array1 {

    public static void main(String[] args) {

        A[] array = new A[] {};
        A a = new A();
        Benchmark.alloc(1);
        A b = new A();
        array[0] = a;
        array[1] = b;
        A c = array[1];
        Benchmark
                .test("c",
                        "{allocId:1, mayAlias:[c,b], notMayAlias:[a,array], mustAlias:[c,b], notMustAlias:[a,array]}");
    }
}

package com.bytecodedl.benchmark.pointsto.sensitivity;

import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.B;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase FieldSensitivity2
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Field Sensitivity without static method
 */
public class FieldSensitivity2 {

    public FieldSensitivity2() {}

    private void assign(A x, A y) {
        y.f = x.f;
    }

    private void test() {
        Benchmark.alloc(1);
        B b = new B();
        A a = new A(b);
        A c = new A();
        assign(a, c);
        B d = c.f;

        Benchmark.test("d",
                "{allocId:1, mayAlias:[d,b], notMayAlias:[a,c], mustAlias:[d,b], notMustAlias:[a,c]}");
    }

    public static void main(String[] args) {

        FieldSensitivity2 fs2 = new FieldSensitivity2();
        fs2.test();
    }

}

package com.bytecodedl.benchmark.pointsto.annotations;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCalls;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({METHOD, CONSTRUCTOR})
@Repeatable(PointsTos.class)
public @interface PointsTo {
    // heap
    String heap();
    // var name
    String var();

}

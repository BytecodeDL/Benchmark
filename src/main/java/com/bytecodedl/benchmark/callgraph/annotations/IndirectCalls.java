package com.bytecodedl.benchmark.callgraph.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Container of the {@link IndirectCall} annotation.
 *
 * @author Florian Kuebler
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface IndirectCalls {

    IndirectCall[] value();

}

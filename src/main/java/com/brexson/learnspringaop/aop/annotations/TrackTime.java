package com.brexson.learnspringaop.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // applicable only on methods
@Retention(RetentionPolicy.RUNTIME) // applicable only at runtime
public @interface TrackTime {
}

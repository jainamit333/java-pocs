package com.amit.annotations;

import java.lang.annotation.*;

/**
 * Created by amit on 20/4/16.
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface SimpleAnnotation {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;
}

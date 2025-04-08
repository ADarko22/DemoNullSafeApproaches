package edu.adarko22;

import javax.annotation.Nullable;

public class NullabilityExample {

    public void nonNullMethod(String param) {
        System.out.println(param);
    }

    // Method with @Nullable
    public void nullableMethod(@Nullable String param) {
        if (param != null) {
            System.out.println(param);
        } else {
            System.out.println("Null parameter");
        }
    }

    public static void main(String[] args) {
        NullabilityExample example = new NullabilityExample();
        example.nonNullMethod("Safe");
        example.nonNullMethod(null);
        example.nullableMethod(null);
    }
}

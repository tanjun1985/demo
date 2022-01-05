package com.example.demo.annotation;

import java.lang.annotation.Annotation;

public class TestAnnotation {
    public static void main(String[] args) {
        Annotation[] annotations = IInheritedInterfaceChild.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
    }
}

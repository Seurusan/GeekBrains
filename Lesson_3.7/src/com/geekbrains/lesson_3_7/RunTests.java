package com.geekbrains.lesson_3_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunTests {
    public static void start(Class testClass) {
        List<Method> methods = new ArrayList<>();
        Method[] listOfMethods = testClass.getDeclaredMethods();

        for (Method method : listOfMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                methods.add(method);
            }
        }

        methods.sort(Comparator
                .comparingInt((Method i) -> i.getAnnotation(Test.class).priority())
                .reversed());

        for (Method method : listOfMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("More than one @BeforeSuite!");
                }
                methods.add(0,method);
            }
        }

        for (Method method : listOfMethods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methods.size() > 0 && methods.get(methods.size()-1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("More than one @AfterSuite!");
                }
                methods.add(methods.size(),method);
            }
        }

        for (Method method : methods) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
    }
}

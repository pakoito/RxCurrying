#RxCurrying

RxCurrying is a library to allow [currying](https://en.wikipedia.org/wiki/Currying) on RxJava function primitives.

##Usage

RxCurrying contains two classes, `RxCurryingAction` and `RxCurryingFunc`. Each contains a set of `curry()` methods to do split any function into its curried version. Curried methods allows calling them one parameter at a time, and execute them at the end. For example, a `Func3<A, B, C, R>` becomes a `Func1<A, Func1<B, Func1<C, Func0<R>>>>`, or an `Action4<A, B, C, D>` becomes `Func1<A, Func1<B, Func1<C, Func1<D, Action0>>>>`.

Function to print the sum of two numbers:
```
Func1<Integer, Action1<Integer>> adder = RxCurryingAction.curry((int first, int second) -> { System.out.print(first + second); });
Action1<Integer> intermediate = adder.call(3);
intermediate.call(2);  // prints 5
```

Append 5 strings:
```
Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>> appender = RxCurryingFunc.curry((String first, String second, String third, String fourth, String fifth) -> { return first + second + third + fourth + fifth; );
Func1<String, String> intermediate = appender.call("Hello ").call("This ").call("Is ").call("Curried ");
String value = last.call("Func"); // value == "Hello This is Curried Func"
```

##Distribution

Add as a dependency to your `build.gradle`

    repositories {
        ...
        maven { url "https://jitpack.io" }
        ...
    }
    
    dependencies {
        ...
        compile 'com.github.pakoito:RxCurrying:1.1.0'
        ...
    }

or to your `pom.xml`

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    
    <dependency>
        <groupId>com.github.pakoito</groupId>
        <artifactId>RxCurrying</artifactId>
        <version>1.1.0</version>
    </dependency>

##License

Copyright (c) pakoito 2016

The Apache Software License, Version 2.0

See LICENSE.md
